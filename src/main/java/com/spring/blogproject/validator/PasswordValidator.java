package com.spring.blogproject.validator;

import com.spring.blogproject.entity.UserRegistration;
import com.spring.blogproject.validator.annotation.Password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, UserRegistration> {
    @Override
    public boolean isValid(UserRegistration userRegistration, ConstraintValidatorContext constraintValidatorContext) {
        String password = userRegistration.getPassword();
        String repeatPassword = userRegistration.getRepeatPassword();

        return password != null && password.equals(repeatPassword);
    }
}
