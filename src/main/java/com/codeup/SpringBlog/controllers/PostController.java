package com.codeup.SpringBlog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String post(String post) {
        return "Posts: " + post;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String postId(String id) {
        return id;
    }
//
    @RequestMapping(value = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String viewPost(String post) {
        return post;
    }

    @PostMapping(value = "/posts/create")
    @ResponseBody
    public String createPost(String post) {
        return post;
    }
}
