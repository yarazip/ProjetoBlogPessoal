package com.blogpessoal.service;

import java.util.List;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blogpessoal.model.Tema;
import com.blogpessoal.repository.TemaRepository;

@Service
public class TemaService {

    @Autowired
    private TemaRepository temaRepository;

    public List<Tema> findAll() {
        return temaRepository.findAll();
    }

    public Optional<Tema> findById(Long id) {
        return temaRepository.findById(id);
    }

    public List<Tema> findByDescricao(String descricao) {
        return temaRepository.findAllByDescricaoContainingIgnoreCase(descricao);
    }

    public Tema save(Tema tema) {
        return temaRepository.save(tema);
    }

    public void delete(Long id) {
        temaRepository.deleteById(id);
    }
}