package com.dileep.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<Post> getAll() {
        List<Post> posts = this.postRepository.findAll();
        return posts;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPostById(@PathVariable(value = "id") Long id) {
        Optional<Post> post = this.postRepository.findById(id);
        if (post.isPresent()) {
            return new ResponseEntity<>(post.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Post not found with id: " + id, HttpStatus.NOT_FOUND);
    }

}
