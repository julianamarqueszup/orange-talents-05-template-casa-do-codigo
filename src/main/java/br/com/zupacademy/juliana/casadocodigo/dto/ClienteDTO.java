package br.com.zupacademy.juliana.casadocodigo.dto;

import br.com.zupacademy.juliana.casadocodigo.model.Cliente;

public class ClienteDTO {
    private Long id;

    private String email;

    private String nome;

    public ClienteDTO(Cliente cliente) {
        id = cliente.getId();
        email = cliente.getEmail();
        nome = cliente.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    public String getNome() {
        return nome;
    }
}
