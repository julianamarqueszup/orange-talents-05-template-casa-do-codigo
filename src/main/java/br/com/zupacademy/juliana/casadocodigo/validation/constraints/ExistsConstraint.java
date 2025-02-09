package br.com.zupacademy.juliana.casadocodigo.validation.constraints;


import br.com.zupacademy.juliana.casadocodigo.validation.annotation.ExistsID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsConstraint implements ConstraintValidator<ExistsID, Object> {
    @PersistenceContext
    private EntityManager manager;

    private String field;

    private String alias;

    private Class<?> modelClass;

    @Override
    public void initialize(ExistsID constraintAnnotation) {
        field = constraintAnnotation.field();
        alias = constraintAnnotation.alias();
        modelClass = constraintAnnotation.modelClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) return true;
        return !createQuery().setParameter("value", value).getResultList().isEmpty();
    }

    private String getTableName() {
        return modelClass.getSimpleName();
    }

    private Query createQuery() {
        var alias = this.alias != null && !this.alias.isEmpty() ? this.alias : this.field;
        return manager.createQuery("from " + getTableName() + " t where t." + alias + " = :value");
    }

}