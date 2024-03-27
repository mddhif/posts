package com.posts.posts.service;

import com.posts.posts.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class PostService {

    @Value("${server.url}")
    String serverUrl;

    //Here we are implementing pagination using page and limit params and passing them to webclient
    public ResponseEntity<Post> getPosts(int page, int limit) {

        Pageable pageable = PageRequest.of(page, limit);

        //use reactive client (from webflux)
        // pass page and limit to webclient
        WebClient webClient = WebClient.create(serverUrl);
        ResponseEntity postsList = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/posts")
                        .queryParam("page", page)
                        .queryParam("limit", limit)
                        .build())
                .retrieve()
                .toEntityList(Post.class)
                .block();

        return postsList;
    }




}
