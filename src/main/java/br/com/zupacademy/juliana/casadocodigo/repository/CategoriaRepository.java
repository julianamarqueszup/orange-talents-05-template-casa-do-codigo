package br.com.zupacademy.juliana.casadocodigo.repository;

import br.com.zupacademy.juliana.casadocodigo.model.Categoria;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Long> {
}
