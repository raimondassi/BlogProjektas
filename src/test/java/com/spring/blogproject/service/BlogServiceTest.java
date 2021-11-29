package com.spring.blogproject.service;

import com.spring.blogproject.entity.Blog;
import com.spring.blogproject.repository.BlogRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BlogServiceTest {

    @Mock
    private BlogRepository blogRepository;

    @InjectMocks
    private BlogService blogService;

    @Test
    public void getAllBlogsTest() {
        Blog blog = new Blog();
        List<Blog> blogs = List.of(blog);
        when(blogRepository.findAll()).thenReturn(blogs);
        List<Blog> response = blogService.findAllBlogs();
        Assertions.assertEquals(blogs, response);
    }

    @Test
    public void getBlogByBlogIdTest() {
        Optional<Blog> blog = Optional.of(new Blog());
        UUID id = UUID.fromString("9a6c2057-9c57-40b9-8aa3-9c6947ead1f3");
        when(blogRepository.findById(any())).thenReturn(blog);
        Optional<Blog> response = Optional.ofNullable(blogService.getBlog(id));
        Assertions.assertEquals(blog, response);
    }

}