package br.com.zupacademy.juliana.casadocodigo.dto;

import br.com.zupacademy.juliana.casadocodigo.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDetalhesDTO {
    private Long id;

    private String titulo;

    private String resumo;

    private String sumario;

    private BigDecimal preco;

    private Integer numeroPaginas;

    private String isbn;

    private LocalDate dataPublicacao;

    private AutorDTO autor;

    private CategoriaDTO categoria;

    public LivroDetalhesDTO(Livro livro) {
        id = livro.getId();
        titulo = livro.getTitulo();
        resumo = livro.getResumo();
        sumario = livro.getSumario();
        preco = livro.getPreco();
        numeroPaginas = livro.getNumeroPaginas();
        isbn = livro.getIsbn();
        dataPublicacao = livro.getDataPublicacao();
        autor = new AutorDTO(livro.getAutor());
        categoria = new CategoriaDTO(livro.getCategoria());
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

    public String getIsbn() { return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public AutorDTO getAutor() {
        return autor;
    }

    public CategoriaDTO getCategory() {
        return categoria;
    }
}

