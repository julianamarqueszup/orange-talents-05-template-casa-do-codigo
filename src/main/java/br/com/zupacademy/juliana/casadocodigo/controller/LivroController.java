package br.com.zupacademy.juliana.casadocodigo.controller;

import br.com.zupacademy.juliana.casadocodigo.dto.LivroDTO;
import br.com.zupacademy.juliana.casadocodigo.exception.NotFoundException;
import br.com.zupacademy.juliana.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.juliana.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.juliana.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.juliana.casadocodigo.request.NovoLivroRequisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

public class LivroController {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<LivroDetalhesDTO> save(@RequestBody @Valid NovoLivroRequisicao req, UriComponentsBuilder uriBuilder) {
        var livro = livroRepository.save(req.toModel(autorRepository, categoriaRepository));
        URI uri = uriBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).body(new LivroDetalhesDTO(livro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> find(@PathVariable Long id) {
        var livro = livroRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        return ResponseEntity.ok(new LivroDTO(livro));
    }

    @GetMapping
    public Page<LivroDTO> list(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pagination) {
        return livroRepository.findAll(pagination).map(LivroDTO::new);
    }

}
