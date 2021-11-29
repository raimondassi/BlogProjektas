package com.spring.blogproject.service;

import com.spring.blogproject.entity.Blog;
import com.spring.blogproject.entity.BlogCategory;
import com.spring.blogproject.entity.BlogCreation;
import com.spring.blogproject.exception.BlogNotExistException;
import com.spring.blogproject.repository.BlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    Page<Blog> getBlogs(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    public void updateBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public Blog getBlog(UUID id) {
        return blogRepository.findById(id).orElseThrow(() -> new BlogNotExistException(id));
    }

    public void deleteBlog(UUID id) {
        blogRepository.deleteById(id);
    }

    public List<Blog> findAllBlogs() {
        return blogRepository.findAll();
    }

    public void createNewBlog(BlogCreation blogCreation) {
        Blog blog = new Blog(
                blogCreation.getTitle(),
                blogCreation.getImage(),
                blogCreation.getText(),
                new Date(System.currentTimeMillis()),
                new BlogCategory(blogCreation.getBlogCategoryId()));

        blogRepository.save(blog);
    }

//    public List<Blog> getAllBlogsByBlogCategory(BlogCategory blogCategory) {
//        return blogRepository.findAllByBlogcategory(blogCategory);
//    }

}
