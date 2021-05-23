package br.com.zupacademy.juliana.casadocodigo.controller;

import br.com.zupacademy.juliana.casadocodigo.dto.AutorDTO;
import br.com.zupacademy.juliana.casadocodigo.exception.NotFoundException;
import br.com.zupacademy.juliana.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.juliana.casadocodigo.request.NovoAutorRequisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AutorDTO> save(@RequestBody @Valid NovoAutorRequisicao req, UriComponentsBuilder uriBuilder) {
        var autor = autorRepository.save(req.toModel());
        URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(new AutorDTO(autor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> find(@PathVariable Long id) {
        var autor = autorRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        return ResponseEntity.ok(new AutorDTO(autor));
    }
}
