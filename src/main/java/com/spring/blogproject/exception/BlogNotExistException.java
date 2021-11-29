package com.spring.blogproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class BlogNotExistException extends RuntimeException {

    private final UUID id;

}
