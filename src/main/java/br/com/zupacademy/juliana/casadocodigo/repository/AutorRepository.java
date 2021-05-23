package br.com.zupacademy.juliana.casadocodigo.repository;

import br.com.zupacademy.juliana.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByEmail(String email);
}
