package com.example.projetovem.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity @Table(name = "tb_user")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "Email")
    private String email;
    @Column(name = "senha")
    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cartao> cartoes = new HashSet<>();

    public Usuario(){}
    public Usuario(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.senha = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Cartao> getCartoes() {
        return cartoes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
