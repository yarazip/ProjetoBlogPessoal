package com.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogpessoal.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
    List<Postagem> findAllByUsuarioId(Long usuarioId);
    List<Postagem> findAllByTemaId(Long temaId);
    List<Postagem> findAllByUsuarioIdAndTemaId(Long usuarioId, Long temaId); // Adicione este método
}