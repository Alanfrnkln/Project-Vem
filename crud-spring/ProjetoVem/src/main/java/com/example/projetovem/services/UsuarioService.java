package com.example.projetovem.services;

import com.example.projetovem.dto.UsuarioDTO;
import com.example.projetovem.dto.mapper.UsuarioMapper;
import com.example.projetovem.entities.Cartao;
import com.example.projetovem.entities.Usuario;
import com.example.projetovem.repositories.UsuarioRepository;
import com.example.projetovem.services.exceptions.DatabaseException;
import com.example.projetovem.services.exceptions.UserNotFoundException;
import org.apache.catalina.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll().stream().map(UsuarioMapper::toDTO).toList();
    }

    public UsuarioDTO listarPorId(Long id) {
        return usuarioRepository.findById(id).map(UsuarioMapper::toDTO)
                        .orElseThrow(() -> new UserNotFoundException(id));
    }

    public UsuarioDTO incluirUsuario(Usuario usuario) {
        return UsuarioMapper.toDTO(usuarioRepository.save(usuario));
    }

    public void deletarUsuario(Long id) {
        try {
            Usuario usuario = usuarioRepository.getReferenceById(id);
            usuarioRepository.delete(usuario);
        } catch (UserNotFoundException e) {
            throw  new UserNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public UsuarioDTO atualizarUsuario(Long id, UsuarioDTO usuario) {
      return usuarioRepository.findById(id).map(usuarioEncontrado -> {
          usuarioEncontrado.setNome(usuario.nome());
          usuarioEncontrado.setEmail(usuario.email());
          return UsuarioMapper.toDTO(usuarioRepository.save(UsuarioMapper.toEntity(usuario)));
      }).orElseThrow(() -> new UserNotFoundException(id));
    }

    public void addCartao(Long id, Cartao cartao, String tipoCartao) {
       Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
       Cartao cartao1 = new Cartao(cartao.getNumeroCartao(), tipoCartao, usuario);

       usuario.getCartoes().add(cartao1);

       usuarioRepository.save(usuario);
    }

    public void changeStatusCard(Long id, Cartao cartao) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        for (Cartao card :
                usuario.getCartoes()) {
            if (card.getNumeroCartao().equals(cartao.getNumeroCartao()))
                card.setStatus(!card.isStatus());
        }

        usuarioRepository.save(usuario);
    }

}
