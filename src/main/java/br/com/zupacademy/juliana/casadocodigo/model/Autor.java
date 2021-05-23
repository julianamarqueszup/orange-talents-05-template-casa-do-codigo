package br.com.zupacademy.juliana.casadocodigo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Lob
    @Column(name = "descricao", length = 400)
    private String descricao;

    @Column(name = "dataCriacao")
    private LocalDate dataCriacao = LocalDate.now();

    @Deprecated
    public Autor() {

    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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
