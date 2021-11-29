package com.spring.blogproject.validator;

import com.spring.blogproject.validator.annotation.FieldComparator;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

@Slf4j
public class FieldCompareValidator implements ConstraintValidator<FieldComparator, Object> {

    private String firstField;
    private String secondField;

    @Override
    public void initialize(FieldComparator constraintAnnotation) {
        firstField = constraintAnnotation.firstField();
        secondField = constraintAnnotation.secondField();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Object fistFieldValue = getFieldValue(o, firstField);
            Object secondFieldValue = getFieldValue(o, secondField);

            return fistFieldValue != null && fistFieldValue.equals(secondFieldValue);
        } catch (Exception e) {
            log.error("Something is wrong" + e.getMessage());
        }
        return false;
    }

    private Object getFieldValue(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Class<?> objectClass = object.getClass();
        Field field = objectClass.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }
}
