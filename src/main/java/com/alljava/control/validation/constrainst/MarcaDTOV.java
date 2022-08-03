package com.alljava.control.validation.constrainst;

import com.alljava.control.validation.MarcaDTOValidation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MarcaDTOValidation.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MarcaDTOV {

    String message() default "Este campo é obrigatório";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
