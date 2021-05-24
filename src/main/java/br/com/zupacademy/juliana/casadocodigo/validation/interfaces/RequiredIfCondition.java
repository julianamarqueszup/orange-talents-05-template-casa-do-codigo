package br.com.zupacademy.juliana.casadocodigo.validation.interfaces;

import javax.persistence.EntityManager;

public interface RequiredIfCondition <T> {
    Boolean isRequired(EntityManager manager, T value);
}
