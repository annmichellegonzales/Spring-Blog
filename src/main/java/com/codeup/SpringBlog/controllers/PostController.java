package com.codeup.SpringBlog.controllers;

import com.codeup.SpringBlog.models.Post;
import com.codeup.SpringBlog.models.User;
import com.codeup.SpringBlog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    private final UserRepository usersDao;

    public PostController(UserRepository usersDao) {
        this.usersDao = usersDao;
    }

    @GetMapping("/posts")

    public String index(Model vModel) {
        List<Post> posts = new ArrayList<>(Arrays.asList(
                new Post("Elric", "My son"),
                new Post("Brooklyn", "House panther"),
                new Post("Gratitude", "Contentment")
        ));
        vModel.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model vModel) {
        Post post = new Post("Test Title", "Test Body");
        vModel.addAttribute("id", id);
        vModel.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPost() {
        User user = new User(
                1,
                "user@mail.com",
                "password",
                1,
                "user"
        );
        Post post = new Post(
                1,
                "Elric",
                "My son-heart.",
                user
        );
        return "redirect:/posts";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String insert() {
        return "Saving a new post...";
    }

}