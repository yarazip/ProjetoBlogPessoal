package com.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.blogpessoal.model.Postagem;
import com.blogpessoal.service.PostagemService;

@RestController
@RequestMapping("/api/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;

    @GetMapping
    public ResponseEntity<List<Postagem>> getAll() {
        return ResponseEntity.ok(postagemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> getById(@PathVariable Long id) {
        return postagemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(postagemService.findByTitulo(titulo));
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<Postagem>> getByFiltro(
            @RequestParam(value = "autor", required = false) Long autorId,
            @RequestParam(value = "tema", required = false) Long temaId) {
        
        if (autorId != null && temaId != null)
            return ResponseEntity.ok(postagemService.findByUsuarioIdAndTemaId(autorId, temaId));
        else if (autorId != null)
            return ResponseEntity.ok(postagemService.findByUsuarioId(autorId));
        else if (temaId != null)
            return ResponseEntity.ok(postagemService.findByTemaId(temaId));
        else
            return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<Postagem> post(@RequestBody Postagem postagem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postagemService.save(postagem));
    }

    @PutMapping
    public ResponseEntity<Postagem> put(@RequestBody Postagem postagem) {
        return ResponseEntity.ok(postagemService.save(postagem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        postagemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}