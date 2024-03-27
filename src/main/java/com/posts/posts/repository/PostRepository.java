package com.posts.posts.repository;

import com.posts.posts.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


//This class should be used for pagination example when querying the database.
// But this is not our case. We are retrieving data from external api (jsonplaceholder.com)
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAll(Pageable pageable);
}
