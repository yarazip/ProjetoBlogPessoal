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

import com.blogpessoal.model.Tema;
import com.blogpessoal.service.TemaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {

    @Autowired
    private TemaService temaService;

    @GetMapping
    public ResponseEntity<List<Tema>> getAll() {
        return ResponseEntity.ok(temaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> getById(@PathVariable Long id) {
        return temaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Tema>> getByDescricao(@RequestParam  String descricao) {
        return ResponseEntity.ok(temaService.findByDescricao(descricao));
    }

    @PostMapping
    public ResponseEntity<Tema> post(@Valid @RequestBody Tema tema) {
        return ResponseEntity.status(HttpStatus.CREATED).body(temaService.save(tema));
    }

    @PutMapping
    public ResponseEntity<Tema> put(@Valid @RequestBody Tema tema) {
        return ResponseEntity.ok(temaService.save(tema));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        temaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}