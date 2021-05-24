package br.com.zupacademy.juliana.casadocodigo.controller;

import br.com.zupacademy.juliana.casadocodigo.dto.ClienteDTO;
import br.com.zupacademy.juliana.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.juliana.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.juliana.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.juliana.casadocodigo.request.NovoClienteRequisicao;
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
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteDTO> save(@RequestBody @Valid NovoClienteRequisicao req, UriComponentsBuilder uriBuilder) {
        var cliente = clienteRepository.save(req.toModel(paisRepository, estadoRepository));
        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
    }

    @GetMapping
    public Page<ClienteDTO> list(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pagination) {
        return clienteRepository.findAll(pagination).map(ClienteDTO::new);
    }
}
