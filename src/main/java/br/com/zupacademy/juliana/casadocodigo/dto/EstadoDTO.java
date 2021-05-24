package br.com.zupacademy.juliana.casadocodigo.dto;

import br.com.zupacademy.juliana.casadocodigo.model.Estado;

public class EstadoDTO {
    private Long id;
    private String nome;

    public EstadoDTO(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getName();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
