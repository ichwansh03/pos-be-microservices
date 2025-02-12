package com.ichwan.employee.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExcludeRequestValidator implements ConstraintValidator<ExcludeRequest, Object> {
    @Override
    public void initialize(ExcludeRequest constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return false;
    }
}
