package com.blogpessoal.controller;

import com.blogpessoal.model.Post;

import com.blogpessoal.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog") 
public class BlogController {

    private final PostService postService;

    public BlogController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String blogHome(Model model) {
        model.addAttribute("posts", postService.listarPostsRecentes());
        return "blog/resources"; 
    }

    @GetMapping("/post/{id}")
    public String verPost(@PathVariable Long id, Model model) {
        Post post = postService.buscarPorId(id)
            .orElseThrow(() -> new RuntimeException("Post não encontrado"));
        model.addAttribute("post", post);
        return "blog/post/detail";
    }
}