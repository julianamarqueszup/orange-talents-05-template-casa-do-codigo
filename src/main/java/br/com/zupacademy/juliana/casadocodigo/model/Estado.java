package br.com.zupacademy.juliana.casadocodigo.model;

import javax.persistence.*;

@Entity
@Table(name = "estados", uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "pais_id"}))
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @Deprecated
    public Estado() {
    }

    public Estado(String name, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public Integer getPaisId() {
        return pais.getId();
    }
}
