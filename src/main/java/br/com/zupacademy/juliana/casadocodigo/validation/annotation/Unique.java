package br.com.zupacademy.juliana.casadocodigo.validation.annotations;


import br.com.zupacademy.juliana.casadocodigo.constraints.UniqueConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UniqueConstraint.class)
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface Unique {

        String field();

        String alias() default "";

        Class<?> modelClass();

        String message() default "deve ser único";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }


