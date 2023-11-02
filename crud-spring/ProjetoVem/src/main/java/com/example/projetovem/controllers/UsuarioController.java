package com.example.projetovem.controllers;

import com.example.projetovem.dto.CartaoDTO;
import com.example.projetovem.dto.UsuarioDTO;
import com.example.projetovem.entities.Cartao;
import com.example.projetovem.entities.Usuario;
import com.example.projetovem.services.CartaoService;
import com.example.projetovem.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CartaoService cartaoService;

    //Listar usuários
    @GetMapping("/users")
    public List<UsuarioDTO> getAll() {
        return usuarioService.listarTodos();
    }

    //Listar usuário por Id
    @GetMapping(value = "/users/{usuarioId}")
    public UsuarioDTO getById(@PathVariable Long usuarioId) {
        return usuarioService.listarPorId(usuarioId);
    }

    //Incluir novo usuário
    @PostMapping("/users/adicionar")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UsuarioDTO adicionarUsuario(@RequestBody Usuario usuario){

      return usuarioService.incluirUsuario(usuario);
    }

    //Remover Usuário
    @DeleteMapping(value = "/users/{usuarioId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletarUsuario(@PathVariable Long usuarioId){
        usuarioService.deletarUsuario(usuarioId);
    }

    //Atualizar usuário
    @PutMapping("/users/{usuarioId}")
    public UsuarioDTO atualizar(@PathVariable Long usuarioId, @RequestBody UsuarioDTO usuario) {
        return usuarioService.atualizarUsuario(usuarioId, usuario);
    }

    // -------------------- Requisições Cartão ------------------------------

    //Listar cartões
    @GetMapping("/cartoes")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Cartao> obterCartoes() {
        return cartaoService.listarCartoes();
    }


    @GetMapping("{id}/meusCartoes")
    @ResponseStatus(code = HttpStatus.OK)
    public Set<Cartao> obterCartoes(@PathVariable Long id) {
        return cartaoService.listarCartoesDeUsuario(id);
    }

    //Adicionar cartão
    @PostMapping(value = "/{usuarioId}/adicionarCartao")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CartaoDTO addCartao(@PathVariable Long usuarioId, @RequestBody Cartao cartao) {
       return cartaoService.adicionarCartao(usuarioId, cartao);
    }

    //Remover Cartão
    @DeleteMapping("/{usuarioId}/{numeroCartao}")
    public void removerCartao(@PathVariable Long usuarioId, @PathVariable Long numeroCartao){
        cartaoService.removerCartao(usuarioId, numeroCartao);
    }

    //Mudar Status do cartão
    @PutMapping(value = "/{numeroCartao}/changeStatus")
    @ResponseStatus(code = HttpStatus.OK)
    public void changeStatus(@PathVariable Long numeroCartao) {
        cartaoService.mudarStatus(numeroCartao);
    }
}
