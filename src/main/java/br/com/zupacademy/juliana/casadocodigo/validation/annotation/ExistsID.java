package br.com.zupacademy.juliana.casadocodigo.validation.annotation;

import br.com.zupacademy.juliana.casadocodigo.validation.constraints.ExistsConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.*;

@Constraint(validatedBy = ExistsConstraint.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExistsID {
    String field();

    String alias() default "";

    Class<?> modelClass();

    String message() default "não existe ID";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}