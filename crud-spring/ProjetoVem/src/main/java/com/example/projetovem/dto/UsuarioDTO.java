package com.example.projetovem.dto;

import com.example.projetovem.entities.Cartao;

import java.util.Set;

public record UsuarioDTO(Long id,
                         String nome,
                         String email,
                         Set<Cartao> cartoes) {
}
