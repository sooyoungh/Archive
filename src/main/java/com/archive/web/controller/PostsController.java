package com.archive.web.controller;

import com.archive.service.posts.PostsService;
import com.archive.web.dto.PostsResponseDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class PostsController {

    PostsService postsService;

    @GetMapping("/posts/view/{id}")
    public String postsView(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        postsService.updateView(id);    //views ++
        model.addAttribute("post",dto);
        return "posts-view";
    }
}
