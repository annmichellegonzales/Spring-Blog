package com.codeup.SpringBlog.controllers;

import com.codeup.SpringBlog.models.Post;
import com.codeup.SpringBlog.models.PostDetails;
import com.codeup.SpringBlog.models.User;
import com.codeup.SpringBlog.repositories.PostRepository;
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

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }


//    index of all posts
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
//        Post post = new Post("Test Title", "Test Body");
        Post post = postDao.getOne(id);
        vModel.addAttribute("id", id);
        vModel.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPost() {
        Post post = new Post(
                "Elric",
                "My son-heart.",
                new PostDetails(true, "asdf", "asdf")
        );
//        User user = userDao.getOne(1L);
        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String insert() {
        return "Saving a new post...";
    }

    @PostMapping("/post/{id}/delete")
    public String deletePost(@PathVariable("id") Long id) {
        postDao.deleteById(id);
        return "redirect:/post";
    }

}