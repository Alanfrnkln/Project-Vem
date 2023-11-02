package com.example.projetovem.repositories;

import com.example.projetovem.entities.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
}
