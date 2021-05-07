package com.codeup.SpringBlog.controllers;

import com.codeup.SpringBlog.models.Post;
import com.codeup.SpringBlog.models.PostDetails;
import com.codeup.SpringBlog.models.User;
import com.codeup.SpringBlog.repositories.PostRepository;
import com.codeup.SpringBlog.repositories.UserRepository;
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


    @PostMapping("/post/delete/{id}")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@RequestParam String title, @RequestParam String body) {
        Post post = new Post();
//        PostDetails postDetails = new PostDetails();
        post.setTitle(title);
        post.setBody(body);
//        postDetails.setHistoryOfPost(postDetails.getHistoryOfPost());
        postDao.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/posts/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model vModel) {
        Post post = postDao.getOne(id);
        vModel.addAttribute("post", post);
        return "post/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editedPost(@PathVariable long id, @ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }

//    @GetMapping("/posts/create")
//    public String createPost() {
//        Post post = new Post(
//                "Elric",
//                "My son-heart.",
//                new PostDetails(true, "asdf", "asdf")
//        );
//        Post user = userDao.getOne(1L);
//        postDao.save(post);
//        return "redirect:/posts";
//    }
}