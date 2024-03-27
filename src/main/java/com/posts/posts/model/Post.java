package com.posts.posts.model;


import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {

    //i needed more details on these 2 fields, should userId be unique in this case ??
    private String userId;
    private String title ;
}
