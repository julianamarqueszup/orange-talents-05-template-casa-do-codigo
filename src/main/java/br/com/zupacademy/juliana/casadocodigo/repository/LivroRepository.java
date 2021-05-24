package br.com.zupacademy.juliana.casadocodigo.repository;

import br.com.zupacademy.juliana.casadocodigo.model.Livro;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LivroRepository extends PagingAndSortingRepository<Livro, Long> {

}
