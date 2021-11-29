package com.spring.blogproject.validator.annotation;

import com.spring.blogproject.validator.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {
    String message() default "{password.constraints.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
