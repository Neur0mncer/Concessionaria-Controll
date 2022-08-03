package com.alljava.control.validation;

import com.alljava.control.DTO.MarcaDTO;
import com.alljava.control.validation.constrainst.MarcaDTOV;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MarcaDTOValidation implements ConstraintValidator<MarcaDTOV, MarcaDTO> {
    @Override
    public void initialize(MarcaDTOV constraintAnnotation) {
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
