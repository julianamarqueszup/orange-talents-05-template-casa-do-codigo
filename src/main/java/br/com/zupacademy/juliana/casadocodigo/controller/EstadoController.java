package br.com.zupacademy.juliana.casadocodigo.controller;

import br.com.zupacademy.juliana.casadocodigo.dto.EstadoDTO;
import br.com.zupacademy.juliana.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.juliana.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.juliana.casadocodigo.request.NovoEstadoRequisicao;
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
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<EstadoDTO> save(@RequestBody @Valid NovoEstadoRequisicao req, UriComponentsBuilder uriBuilder) {
        var estado = estadoRepository.save(req.toModel(paisRepository));
        URI uri = uriBuilder.path("/estados/{id}").buildAndExpand(estado.getId()).toUri();
        return ResponseEntity.created(uri).body(new EstadoDTO(estado));
    }

    @GetMapping
    public Page<EstadoDTO> list(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pagination) {
        return estadoRepository.findAll(pagination).map(EstadoDTO::new);
    }
}
