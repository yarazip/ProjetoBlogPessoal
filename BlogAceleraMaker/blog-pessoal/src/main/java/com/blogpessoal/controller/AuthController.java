package com.blogpessoal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.AuthenticationException;


import com.blogpessoal.security.JwtService;
import com.blogpessoal.security.UserDetailsServiceImpl;

@Controller
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String senha,
                        Model model) {

        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, senha));

            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            String token = jwtService.generateToken(userDetails);

            model.addAttribute("token", token);
            model.addAttribute("usuario", email);
            return "dashboard";

        }  catch (AuthenticationException e) {
            model.addAttribute("erro", "Email ou senha inválidos.");
            return "login";
        }

    }
}
