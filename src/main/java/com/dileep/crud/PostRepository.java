package com.dileep.crud;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findAll();
    Optional<Post> findById(Long id);
}
