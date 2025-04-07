package com.blogpessoal.service;

import com.blogpessoal.model.Post;
import com.blogpessoal.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> listarPostsRecentes() {
        return postRepository.findAllByOrderByDataPublicacaoDesc();
    }

    public Optional<Post> buscarPorId(Long id) {
        return postRepository.findById(id);
    }

    public Post salvar(Post post) {
        return postRepository.save(post);
    }

    public void deletarPorId(Long id) {
        if (!postRepository.existsById(id)) {
            throw new RuntimeException("Post não encontrado com o ID: " + id);
        }
        postRepository.deleteById(id);
    }

    public Page<Post> listarPaginado(Pageable pageable) {
        return postRepository.findAll(pageable);
    }
}
