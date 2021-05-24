package br.com.zupacademy.juliana.casadocodigo.request;

import br.com.zupacademy.juliana.casadocodigo.model.Pais;
import br.com.zupacademy.juliana.casadocodigo.validation.annotation.Unique;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequisicao {
    @NotBlank
    @Unique(field = "name", modelClass = Pais.class)
    private String nome;

    @Deprecated
    public NovoPaisRequisicao() {
    }

    public String getNome() {
        return nome;
    }

    public Pais toModel() {
        return new Pais(nome);
    }
}
