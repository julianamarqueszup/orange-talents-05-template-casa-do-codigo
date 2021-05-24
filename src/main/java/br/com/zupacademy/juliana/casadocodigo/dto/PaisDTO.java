package br.com.zupacademy.juliana.casadocodigo.dto;

import br.com.zupacademy.juliana.casadocodigo.model.Pais;

public class PaisDTO {
    private Integer id;

    private String nome;

    public PaisDTO(Pais pais) {
        this.id = pais.getId();
        this.nome = pais.getNome();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
