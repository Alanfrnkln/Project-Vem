package com.example.projetovem.services.exceptions;

public class CardNotFoundException extends RuntimeException{
    public CardNotFoundException(Long numeroCartao) {
        super("Cartão não encontrado. Numero do cartão: " + numeroCartao);
    }
}
