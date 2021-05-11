package com.codeup.SpringBlog.controllers;

import com.codeup.SpringBlog.models.Post;
import com.codeup.SpringBlog.models.User;
import com.codeup.SpringBlog.repositories.PostRepository;
import com.codeup.SpringBlog.repositories.UserRepository;
import com.codeup.SpringBlog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;



    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }


    @GetMapping("/posts")
    public String index(Model vModel) {
        vModel.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }


//    @GetMapping("/posts/{id}")
//    public String show(@PathVariable long id, Model vModel) {
//        Post post = postDao.getOne(id);
//        vModel.addAttribute("id", id);
//        vModel.addAttribute("post", post);
//        return "posts/show";
//    }


    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model vModel) {
        vModel.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }


//    @PostMapping("/posts/{id}/delete")
//    public String deletePost(@PathVariable long id, Model model) {
//        Post post = postDao.getOne(id);
//        postDao.delete(post);
//        return "redirect:/posts";
//    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }



    @GetMapping("/posts/create")
    public String showCreateForm(Model vModel) {
        vModel.addAttribute("post", new Post());
//        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "posts/create";
    }

//    @PostMapping("/posts/create")
//    public String create(@ModelAttribute Post post) {
//        emailService.prepareAndSend(post, "Post Created!", "You have just created a post!");
//        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User author = userDao.getOne(principal.getId());
//        post.setUser(author);
//        Post savedPost = postDao.save(post);
//        return "redirect:/posts/" + savedPost.getId();
//    }

    @PostMapping("/posts/create")
    public String insert(@ModelAttribute Post post, PostDetails postDetails) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User author = userDao.getOne(principal.getId());
        post.setUser(author);
        Post savedPost = postDao.save(post);
//        Post.postDetails.historyOfPost =;
        emailService.prepareAndSend(post, "Post Created!", "You have just created a post!");
        return "redirect:/posts/" + savedPost.getId();
    }


    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model vModel) {
        Post postToEdit = postDao.getOne(id);
        vModel.addAttribute("post", postToEdit);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/post/{id}/delete")
    public String deletePost(@PathVariable("id") Long id) {
        postDao.deleteById(id);
        return "redirect:/post";
    }

}