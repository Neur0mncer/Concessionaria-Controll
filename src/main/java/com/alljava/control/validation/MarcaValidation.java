package com.alljava.control.validation;

import com.alljava.control.DTO.MarcaDTO;
import com.alljava.control.validation.constrainst.MarcaV;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MarcaValidation implements ConstraintValidator<MarcaV, MarcaDTO> {
    @Override
    public void initialize(MarcaV constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MarcaDTO value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null){
            return false;
        }else
            return true;
    }
}
