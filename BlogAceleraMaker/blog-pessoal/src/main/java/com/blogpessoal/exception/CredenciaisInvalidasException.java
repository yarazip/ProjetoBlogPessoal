package com.blogpessoal.exception;

public class CredenciaisInvalidasException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CredenciaisInvalidasException() {
        super("Credenciais inválidas. Verifique o email e a senha.");
    }

    public CredenciaisInvalidasException(String message) {
        super(message);
    }
}
