package br.uff.exercicio4.service;

import br.uff.exercicio4.modelo.Usuario;
import br.uff.exercicio4.repository.UsuarioRepository;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class UsuarioService {

    private final Validator validator;

    private final UsuarioRepository usuarioRepository;
   
    @Transactional(readOnly = true)
    public Usuario findObjById(long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Usuario com id %d não encontrado".formatted(id)));
    }

    @Transactional(readOnly = true)
    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }
   
}
