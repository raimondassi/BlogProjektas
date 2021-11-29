package com.spring.blogproject.validator.annotation;

import com.spring.blogproject.validator.FieldCompareValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldCompareValidator.class)
public @interface FieldComparator {
    String message() default "{field.comparator.constraints.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String firstField();

    String secondField();

}
