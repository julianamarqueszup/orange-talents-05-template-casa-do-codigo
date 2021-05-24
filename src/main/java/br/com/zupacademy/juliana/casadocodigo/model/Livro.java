package br.com.zupacademy.juliana.casadocodigo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", unique = true)
    private String titulo;

    @Lob
    @Column(name = "resumo", length = 500)
    private String resumo;

    @Lob
    @Column(name = "sumario", nullable = true)
    private String sumario;

    @Column(name = "preco", precision = 2)
    private BigDecimal preco;

    @Column(name = "numeroPaginas")
    private Integer numeroPaginas;

    @Column(unique = true)
    private String isbn;

    @Column(name = "dataPublicacao")
    private LocalDate dataPublicacao;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas, String isbn, LocalDate dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

}
