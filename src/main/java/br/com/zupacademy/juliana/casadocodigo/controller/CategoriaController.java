package br.com.zupacademy.juliana.casadocodigo.controller;

import br.com.zupacademy.juliana.casadocodigo.dto.CategoriaDTO;
import br.com.zupacademy.juliana.casadocodigo.exception.NotFoundException;
import br.com.zupacademy.juliana.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.juliana.casadocodigo.request.NovaCategoriaRequisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDTO> save(@RequestBody @Valid NovaCategoriaRequisicao req, UriComponentsBuilder uriBuilder) {
        var categoria = categoriaRepository.save(req.toModel());
        URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoriaDTO(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> find(@PathVariable Long id) {
        var categoria = categoriaRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        return ResponseEntity.ok(new CategoriaDTO(categoria));
    }
}
