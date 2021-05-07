package com.codeup.SpringBlog.controllers;

import com.codeup.SpringBlog.models.Post;
import com.codeup.SpringBlog.models.PostDetails;
import com.codeup.SpringBlog.models.User;
import com.codeup.SpringBlog.repositories.PostRepository;
import com.codeup.SpringBlog.repositories.UserRepository;
import com.codeup.SpringBlog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

//  index of all posts
    @GetMapping("/posts")
    public String index(Model vModel) {
        List<Post> posts = postDao.findAll();
        vModel.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model vModel) {
        Post post = postDao.getOne(id);
        vModel.addAttribute("id", id);
        vModel.addAttribute("post", post);
        return "posts/show";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id, Model model) {
        Post post = postDao.getOne(id);
        postDao.delete(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {
//        postDetails.setHistoryOfPost(postDetails.getHistoryOfPost());
        emailService.prepareAndSend(post, "title", "body");
        postDao.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable("id") long id, Model vModel) {
        Post post = postDao.getOne(id);
        vModel.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editedPost(@PathVariable("id") long id, @ModelAttribute Post post) {
        postDao.getOne(id);
        postDao.save(post);
        return "redirect:/posts";
    }

}