package com.alljava.control.validation;

import com.alljava.control.entities.Marca;
import com.alljava.control.validation.constrainst.MarcaV;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MarcaValidation implements ConstraintValidator<MarcaV, Marca> {
    @Override
    public void initialize(MarcaV constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Marca value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null){
            return false;
        }else
            return true;
    }
}
