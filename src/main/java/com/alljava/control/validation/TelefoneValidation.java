package com.alljava.control.validation;

import com.alljava.control.validation.constrainst.Telefone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Size;

public class TelefoneValidation implements ConstraintValidator<Telefone, String> {

    @Override
    public void initialize(Telefone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        String telefone = value == null ? "" : value;
        return telefone.matches("[0-9]{1,20}");
    }
}
