package com.spring.blogproject.controller;

import com.spring.blogproject.entity.*;
import com.spring.blogproject.repository.CommentRepository;
import com.spring.blogproject.service.BlogCategoryService;
import com.spring.blogproject.service.BlogService;
import com.spring.blogproject.validator.BlogCreationValidator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/blogs")
public class BlogController {

    private static final Logger LOG = LoggerFactory.getLogger(UserRegistrationController.class);
    BlogCreationValidator blogCreationValidator;

    @Autowired
    private BlogService blogService;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BlogCategoryService blogCategoryService;

    @GetMapping

    public String listAllInfo(Model model) {
        List<Blog> blogs = blogService.findAllBlogs();
        List<Comment> comments = commentRepository.findAll();
        List<BlogCategory> blogCategories = blogCategoryService.getAllBlogCategories();
        //   List<Blog> filterBlogsByCategory = blogService.getAllBlogsByBlogCategory(new BlogCategory());

        model.addAttribute("blogs", blogs);
        model.addAttribute("comments", comments);
        model.addAttribute("blogcategories", blogCategories);
        //   model.addAttribute("filterByBlogCategory", filterBlogsByCategory);
        return "index";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/private/create")
    public String createNewBlog(@Valid BlogCreation blogCreation, BindingResult bindingResult) {
//        blogCreationValidator.validate(blogCreation, bindingResult);
        if (bindingResult.hasErrors()) {
            LOG.warn("blog cannot be created {}", blogCreation);
            return "blogCreation";
        }
        blogService.createNewBlog(blogCreation);
        return "redirect:/blogs/private/create";
    }

    @GetMapping("/private/create")
    public String openRegistrationPage(Model model) {
        List<BlogCategory> blogCategories = blogCategoryService.getAllBlogCategories();
        model.addAttribute("blogcategories", blogCategories);
        model.addAttribute("blogCreation", new BlogCreation());
        LOG.info("Blog creation opened");

        return "blogCreation";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/private/category/create")
    public String createNewCategory(@Valid BlogCategoryCreation blogCategoryCreation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            LOG.warn("category cannot be created {}", blogCategoryCreation);
            return "categoryCreation";
        }
        blogCategoryService.createNewCategory(blogCategoryCreation);
        return "redirect:/blogs/private/category/create";
    }

    @GetMapping("/private/category/create")
    public String openCategoryRegistrationPage(Model model) {
        model.addAttribute("categoryCreation", new BlogCategoryCreation());
        LOG.info("Category creation opened");
        return "categoryCreation";
    }

}
