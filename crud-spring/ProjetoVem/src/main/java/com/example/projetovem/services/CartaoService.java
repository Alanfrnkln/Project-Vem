package com.example.projetovem.services;

import com.example.projetovem.dto.CartaoDTO;
import com.example.projetovem.dto.mapper.CartaoMapper;
import com.example.projetovem.entities.Cartao;
import com.example.projetovem.entities.Usuario;
import com.example.projetovem.repositories.CartaoRepository;
import com.example.projetovem.repositories.UsuarioRepository;
import com.example.projetovem.services.exceptions.CardNotFoundException;
import com.example.projetovem.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Listar Cartões
    public List<Cartao> listarCartoes(){
        return cartaoRepository.findAll();
    }


    public Set<Cartao> listarCartoesDeUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return usuario.getCartoes();
    }

    //Adicionar cartão
    public CartaoDTO adicionarCartao(Long usuarioId, Cartao cartao) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new UserNotFoundException(usuarioId));

        cartao.setUser(usuario);
        return CartaoMapper.toDTO(cartaoRepository.save(cartao));
    }

    //Remover cartão
    public void removerCartao(Long usuarioId, Long numeroCartao) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new UserNotFoundException(usuarioId));
        Cartao cartao = cartaoRepository.findById(numeroCartao).orElseThrow(() -> new CardNotFoundException(numeroCartao));

        if(!usuario.getCartoes().contains(cartao)) throw new IllegalArgumentException("O cartão não pertence ao usuário!");

        usuario.getCartoes().remove(cartao);
        usuarioRepository.save(usuario);
    }

    //Mudar status do cartão
    public Cartao mudarStatus(Long numeroCartao) {
        Cartao cartao = cartaoRepository.findById(numeroCartao).orElseThrow(() -> new CardNotFoundException(numeroCartao));

        cartao.setStatus(!cartao.isStatus());
        return cartaoRepository.save(cartao);
    }
}
