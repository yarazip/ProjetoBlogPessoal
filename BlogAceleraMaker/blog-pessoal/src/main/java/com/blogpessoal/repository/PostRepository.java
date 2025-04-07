package com.blogpessoal.repository;

import com.blogpessoal.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByDataPublicacaoDesc();
}