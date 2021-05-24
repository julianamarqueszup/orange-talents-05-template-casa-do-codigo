package br.com.zupacademy.juliana.casadocodigo.dto;

import br.com.zupacademy.juliana.casadocodigo.model.Categoria;

public class CategoriaDTO {
    private Long id;

    private String nome;

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public String getName() {
        return nome;
    }

    public Long getId() {
        return id;
    }
}
