package com.posts.posts.controller;


import com.posts.posts.model.Post;
import com.posts.posts.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class PostController {


    @Autowired
    private PostService postService;


    //in case no page and limit were provided, they will default to 1 and 20, respectively
    @GetMapping("/posts")
    public ResponseEntity<Post> getPosts(@RequestParam(defaultValue = "1") int page,
                                         @RequestParam(defaultValue = "20") int limit) {

        log.info("page: {}, limit: {}", page, limit);
        return postService.getPosts(page, limit);

    }
}
