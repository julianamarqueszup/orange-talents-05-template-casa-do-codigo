package br.com.zupacademy.juliana.casadocodigo.repository;

import br.com.zupacademy.juliana.casadocodigo.model.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {
}
