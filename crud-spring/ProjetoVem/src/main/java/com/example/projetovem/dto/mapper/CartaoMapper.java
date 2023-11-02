package com.example.projetovem.dto.mapper;

import com.example.projetovem.dto.CartaoDTO;
import com.example.projetovem.entities.Cartao;

public class CartaoMapper {
    public static CartaoDTO toDTO(Cartao cartao){
        if (cartao == null) return null;

       return new CartaoDTO(cartao.getNumeroCartao(), cartao.getUser().getNome(), cartao.getTipoCartao());
    }

    public static Cartao toEntity(CartaoDTO dto) {
        if (dto == null) return null;
        Cartao cartao = new Cartao();
        if (dto.numeroCartao() != null) cartao.setNumeroCartao(dto.numeroCartao());

        cartao.setTipoCartao(dto.tipoCartao());
        return cartao;
    }
}
