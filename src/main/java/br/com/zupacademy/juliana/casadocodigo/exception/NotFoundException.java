package br.com.zupacademy.juliana.casadocodigo.exception;

public class NotFoundException extends RuntimeException {
    private Object id;

    public NotFoundException(Object id) {
        super("Não encontrado com o ID " + id);
    }
}
