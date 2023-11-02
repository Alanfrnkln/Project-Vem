package com.example.projetovem.services.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Object id) {
        super("Usuário não encontrado. Id " + id);
    }
}
