package com.blogpessoal.exception;

public class AuthenticationException extends Exception {
    private static final long serialVersionUID = 1L;

    public AuthenticationException() {
        super("Erro de autenticação.");
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
