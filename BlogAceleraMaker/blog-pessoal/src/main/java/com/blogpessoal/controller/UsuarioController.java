package com.blogpessoal.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpessoal.dto.CredenciaisDTO;
import com.blogpessoal.dto.UsuarioDTO;
import com.blogpessoal.dto.UsuarioLoginDTO;
import com.blogpessoal.exception.UsuarioExistenteException;
import com.blogpessoal.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; 
    }



    @PostMapping("/login")
    public ResponseEntity<CredenciaisDTO> login(@RequestBody @Valid UsuarioLoginDTO loginDTO) {
        return usuarioService.autenticarUsuario(loginDTO)
            .map(tokenDTO -> ResponseEntity.ok(tokenDTO))
            .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> registerUser(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        return usuarioService.cadastrarUsuario(usuarioDTO.toUsuario())
                .map(usuario -> ResponseEntity.status(HttpStatus.CREATED).body(UsuarioDTO.from(usuario)))
                .orElseThrow(UsuarioExistenteException::new);
    }
}
