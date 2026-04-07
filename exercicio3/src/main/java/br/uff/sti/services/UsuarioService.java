package br.uff.sti.services;

import br.uff.sti.models.Usuario;
import br.uff.sti.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author leandroribeirodecicco
 */

@Service
@AllArgsConstructor
@Slf4j
public class UsuarioService {

    public static final String URL_IMAGEM_1 = "https://fastly.picsum.photos/id/872/200/200.jpg?hmac=m0AwAUFkEiEz2KW58n6a5RVkKaClHNylfppYjE3a0v4";

    public final UsuarioRepository usuarioRepository;
    
    @Transactional
    public Usuario save(Usuario usuario){        
        return usuarioRepository.save(usuario);        
    }
    
    @Transactional
    public void deleteAll(){
        usuarioRepository.deleteAll();
    }
    
    public Usuario getLastInserted(){
        return usuarioRepository.findFirst1ByOrderByIdDesc();
    }

}
