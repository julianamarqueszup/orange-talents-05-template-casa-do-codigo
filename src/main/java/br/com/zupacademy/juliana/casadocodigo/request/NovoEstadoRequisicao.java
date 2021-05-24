package br.com.zupacademy.juliana.casadocodigo.request;

import br.com.zupacademy.juliana.casadocodigo.exception.NotFoundException;
import br.com.zupacademy.juliana.casadocodigo.model.Estado;
import br.com.zupacademy.juliana.casadocodigo.model.Pais;
import br.com.zupacademy.juliana.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.juliana.casadocodigo.validation.annotation.ExistsID;
import br.com.zupacademy.juliana.casadocodigo.validation.annotation.FieldAlias;
import br.com.zupacademy.juliana.casadocodigo.validation.annotation.UniqueValues;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

@UniqueValues(modelClass = Estado.class, fields = {"nome", "paisId"})
public class NovoEstadoRequisicao {
    @NotBlank
    private String nome;

    @NotNull
    @ExistsID(field = "id", modelClass = Pais.class)
    @FieldAlias("pais.id")
    private Integer paisId;

    public NovoEstadoRequisicao(String nome, Integer paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }
    public String getNome() {
        return nome;
    }

    public Integer getPaisId() {
        return paisId;
    }

    public Estado toModel(PaisRepository paisRepository) {
        var pais = paisRepository.findById(paisId).orElseThrow(() -> new NotFoundException(paisId));
        return new Estado(nome, pais);
    }
}
