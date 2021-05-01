package com.codeup.SpringBlog.controllers;

import com.codeup.SpringBlog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    List<Post> posts = new ArrayList<>();

    public PostController() {
        posts.add(new Post("Elric", "My son-heart."));
        posts.add(new Post("Happiness", "Contentment and being."));
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postView(@PathVariable long id, Model model) {
        Post post = new Post("Testing", "test post");
        return "posts/index";
    }

    @PostMapping(value = "/posts/create")
    @ResponseBody
    public String createPost() {
        return "create";
    }
}
