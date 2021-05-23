package br.com.zupacademy.juliana.casadocodigo.dto;

import br.com.zupacademy.juliana.casadocodigo.model.Autor;

import java.time.LocalDate;

public class AutorDTO {
    private Long id;

    private String nome;

    private String email;

    private String descricao;

    private LocalDate dataCriacao;

    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.dataCriacao = autor.getDataCriacao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
}

