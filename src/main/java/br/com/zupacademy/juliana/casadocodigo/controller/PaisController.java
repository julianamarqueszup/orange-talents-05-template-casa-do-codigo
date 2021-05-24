package br.com.zupacademy.juliana.casadocodigo.controller;

import br.com.zupacademy.juliana.casadocodigo.dto.PaisDTO;
import br.com.zupacademy.juliana.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.juliana.casadocodigo.request.NovoPaisRequisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/paises")
public class PaisController {
    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<PaisDTO> save(@RequestBody @Valid NovoPaisRequisicao req, UriComponentsBuilder uriBuilder) {
        var pais = paisRepository.save(req.toModel());
        URI uri = uriBuilder.path("/paises/{id}").buildAndExpand(pais.getId()).toUri();
        return ResponseEntity.created(uri).body(new PaisDTO(pais));
    }

    @GetMapping
    public Page<PaisDTO> list(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pagination) {
        return paisRepository.findAll(pagination).map(PaisDTO::new);
    }
}
