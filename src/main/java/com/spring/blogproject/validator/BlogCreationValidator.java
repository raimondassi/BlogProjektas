package com.spring.blogproject.validator;

import com.spring.blogproject.entity.BlogCreation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class BlogCreationValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BlogCreation.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "blogCreationValidator.title");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "image", "blogCreationValidator.image");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "blogCreationValidator.text");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "blogCategoryId", "blogCreationValidator.blogCategoryId");
    }
}
