package com.example.projetovem.config;

import com.example.projetovem.entities.Cartao;
import com.example.projetovem.entities.Usuario;
import com.example.projetovem.repositories.CartaoRepository;
import com.example.projetovem.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Override
    public void run(String... args) throws Exception {
        Usuario u1 = new Usuario("Alan", "alan@gmail.com", "123456a");
        Usuario u2 = new Usuario("Camila", "camila@gmail.com", "12346656a");
        Usuario u3 = new Usuario("Guilherme", "gui@gmail.com", "123422256a");

        usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));

        Cartao c1 = new Cartao(null, "TRABALHADOR", u1);
        Cartao c2 = new Cartao(null, "ESTUDANTIL", u2);
        Cartao c3 = new Cartao(null, "COMUM", u3);
        Cartao c4 = new Cartao(null, "TRABALHADOR", u2);
        Cartao c5 = new Cartao(null, "ESTUDANTIL", u1);

        cartaoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));

        c1.changeStatusCard();
        cartaoRepository.save(c1);
    }
 }
