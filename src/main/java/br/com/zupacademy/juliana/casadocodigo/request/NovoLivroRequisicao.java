package br.com.zupacademy.juliana.casadocodigo.request;

import br.com.zupacademy.juliana.casadocodigo.exception.NotFoundException;
import br.com.zupacademy.juliana.casadocodigo.model.Autor;
import br.com.zupacademy.juliana.casadocodigo.model.Categoria;
import br.com.zupacademy.juliana.casadocodigo.model.Livro;
import br.com.zupacademy.juliana.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.juliana.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.juliana.casadocodigo.validation.annotation.ExistsID;
import br.com.zupacademy.juliana.casadocodigo.validation.annotation.Unique;
import com.sun.istack.NotNull;

import javax.validation.constraints.*;
import java.awt.print.Book;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequisicao {
    @NotBlank
    @Unique(field = "title", modelClass = Book.class)
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @DecimalMin("20")
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numeroPaginas;

    @NotBlank
    @Unique(field = "isbn", modelClass = Livro.class)
    private String isbn;

    @Future
    private LocalDate dataPublicacao;

    @NotNull
    @ExistsID(field = "id", modelClass = Categoria.class)
    private Long categoriaId;

    @NotNull
    @ExistsID(field = "id", modelClass = Autor.class)
    private Long autorId;

    public NovoLivroRequisicao(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario, @NotNull @NotEmpty @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numeroPaginas, @NotBlank String isbn, @Future LocalDate dataPublicacao, @NotNull Long categoriaId, @NotNull Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public Livro toModel(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        var autor = autorRepository.findById(autorId).orElseThrow(() -> new NotFoundException(autorId));
        var categoria = categoriaRepository.findById(categoriaId).orElseThrow(() -> new NotFoundException(categoriaId));
        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
    }
}