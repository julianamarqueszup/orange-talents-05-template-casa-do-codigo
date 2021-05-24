package br.com.zupacademy.juliana.casadocodigo.request;

import br.com.zupacademy.juliana.casadocodigo.exception.NotFoundException;
import br.com.zupacademy.juliana.casadocodigo.model.Cliente;
import br.com.zupacademy.juliana.casadocodigo.model.Estado;
import br.com.zupacademy.juliana.casadocodigo.model.Pais;
import br.com.zupacademy.juliana.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.juliana.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.juliana.casadocodigo.validation.RequiredIfCountryHasState;
import br.com.zupacademy.juliana.casadocodigo.validation.annotation.CpfOrCnpj;
import br.com.zupacademy.juliana.casadocodigo.validation.annotation.ExistsID;
import br.com.zupacademy.juliana.casadocodigo.validation.annotation.RequiredIf;
import br.com.zupacademy.juliana.casadocodigo.validation.annotation.Unique;
import br.com.zupacademy.juliana.casadocodigo.validation.interfaces.CnpjGroup;
import br.com.zupacademy.juliana.casadocodigo.validation.interfaces.CpfGroup;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@RequiredIf(field = "estadoId", condition = RequiredIfCountryHasState.class)
public class NovoClienteRequisicao {
    @Email
    @Unique(field = "email", modelClass = Cliente.class)
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CpfOrCnpj
    @Unique(field = "documento", modelClass = Cliente.class)
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ExistsID(field = "id", modelClass = Pais.class)
    private Integer paisId;

    @ExistsID(field = "id", modelClass = Estado.class)
    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public NovoClienteRequisicao(@Email String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank @CPF(groups = CpfGroup.class) @CNPJ(groups = CnpjGroup.class) String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Integer paisId, Long estadoId, @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Integer getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        var pais = paisRepository.findById(paisId).orElseThrow(() -> new NotFoundException(paisId));
        Estado estado = null;
        if (estadoId != null) {
            estado = estadoRepository.findById(estadoId).orElseThrow(() -> new NotFoundException(estadoId));
        }
        return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, estado, telefone, cep);
    }
}
