package com.example.projetovem.repositories;

import com.example.projetovem.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
