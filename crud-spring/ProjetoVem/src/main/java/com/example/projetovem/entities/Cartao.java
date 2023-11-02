package com.example.projetovem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_cartao")
public class Cartao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroCartao;
    private String nome;
    private boolean status;
    private String tipoCartao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    public Cartao() {
    }

    public Cartao(Long numeroCartao, String tipoCartao, Usuario usuario) {
        this.numeroCartao = numeroCartao;
        this.setNome(usuario.getNome());
        this.status = true;
        this.tipoCartao = tipoCartao;
        this.usuario = usuario;
    }

    public Long getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Long numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(String tipoCartao) {
      this.tipoCartao = tipoCartao;
    }

    @JsonIgnore
    public Usuario getUser() {
        return usuario;
    }

    public void setUser(Usuario usuario) {
        this.usuario = usuario;
    }

    public void changeStatusCard() {
        this.status = !this.status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cartao cartao = (Cartao) o;
        return Objects.equals(numeroCartao, cartao.numeroCartao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCartao);
    }
}
