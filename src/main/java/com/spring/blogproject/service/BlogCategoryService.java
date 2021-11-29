package com.spring.blogproject.service;

import com.spring.blogproject.entity.BlogCategory;
import com.spring.blogproject.entity.BlogCategoryCreation;
import com.spring.blogproject.exception.BlogNotExistException;
import com.spring.blogproject.repository.BlogCategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogCategoryService {

    private final BlogCategoryRepository blogCategoryRepository;

    public BlogCategoryService(BlogCategoryRepository blogCategoryRepository) {
        this.blogCategoryRepository = blogCategoryRepository;
    }

    public void saveBlogCategory(BlogCategory blogCategory) {
        blogCategoryRepository.save(blogCategory);
    }

    Page<BlogCategory> getBlogCategories(Pageable pageable) {
        return blogCategoryRepository.findAll(pageable);
    }

    public void updateBlogCategory(BlogCategory blogCategory) {
        blogCategoryRepository.save(blogCategory);
    }

    public BlogCategory getBlogCategory(UUID id) {
        return blogCategoryRepository.findById(id).orElseThrow(() -> new BlogNotExistException(id));
    }

    public void deleteBlogCategory(UUID id) {
        blogCategoryRepository.deleteById(id);
    }

    public List<BlogCategory> getAllBlogCategories() {
        return blogCategoryRepository.findAll();
    }

    public void createNewCategory(BlogCategoryCreation blogCategoryCreation) {
        BlogCategory blogCategory = new BlogCategory(blogCategoryCreation.getName());
        blogCategoryRepository.save(blogCategory);
    }

}
