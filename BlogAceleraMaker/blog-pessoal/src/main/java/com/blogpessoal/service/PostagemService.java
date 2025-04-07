package com.blogpessoal.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blogpessoal.model.Postagem;
import com.blogpessoal.repository.PostagemRepository;

@Service
public class PostagemService {
	

    @Autowired
    private PostagemRepository postagemRepository;

    public List<Postagem> findAll() {
        return postagemRepository.findAll();
    }

    public Optional<Postagem> findById(Long id) {
        return postagemRepository.findById(id);
    }

    public List<Postagem> findByTitulo(String titulo) {
        return postagemRepository.findAllByTituloContainingIgnoreCase(titulo);
    }

    public List<Postagem> findByUsuarioId(Long usuarioId) {
        return postagemRepository.findAllByUsuarioId(usuarioId);
    }

    public List<Postagem> findByTemaId(Long temaId) {
        return postagemRepository.findAllByTemaId(temaId);
    }

    public List<Postagem> findByUsuarioIdAndTemaId(Long usuarioId, Long temaId) {
        return postagemRepository.findAllByUsuarioIdAndTemaId(usuarioId, temaId);
    }

    public Postagem save(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    public void delete(Long id) {
        if (postagemRepository.existsById(id)) {
            postagemRepository.deleteById(id);
        } else {
            throw new RuntimeException("Postagem não encontrada com o ID: " + id);
        }
    }

}