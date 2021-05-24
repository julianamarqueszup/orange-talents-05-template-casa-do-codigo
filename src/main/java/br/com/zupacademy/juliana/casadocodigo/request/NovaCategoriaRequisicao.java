package br.com.zupacademy.juliana.casadocodigo.request;

import br.com.zupacademy.juliana.casadocodigo.model.Categoria;
import br.com.zupacademy.juliana.casadocodigo.validation.annotation.Unique;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequisicao {
    @NotBlank
    @Unique(modelClass = Categoria.class,field = "nome")
    private String nome;

    @Deprecated
    public NovaCategoriaRequisicao() {
    }

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }
}
