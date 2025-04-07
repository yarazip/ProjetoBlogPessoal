package com.blogpessoal.exception;

public class UsuarioExistenteException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UsuarioExistenteException() {
        super("Usuário já existe.");
    }

    public UsuarioExistenteException(String message) {
        super(message);
    }
}
