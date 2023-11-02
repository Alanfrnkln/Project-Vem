package com.example.projetovem.dto.mapper;

import com.example.projetovem.dto.UsuarioDTO;
import com.example.projetovem.entities.Cartao;
import com.example.projetovem.entities.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioMapper {
    public static UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;
        return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getCartoes());
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) return null;
        Usuario usuario = new Usuario();
        if (dto.id() != null) usuario.setId(dto.id());
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        return usuario;
    }
}
