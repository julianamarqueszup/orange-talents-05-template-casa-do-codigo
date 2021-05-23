package br.com.zupacademy.juliana.casadocodigo.request;

import br.com.zupacademy.juliana.casadocodigo.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequisicao {
    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public NovoAutorRequisicao(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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

    public Autor toModel() {
        return new Autor(nome, email, descricao);
    }
}

