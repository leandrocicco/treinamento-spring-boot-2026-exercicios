package br.uff.sti.runners;

import br.uff.sti.models.dto.PostComUsuarioDTO;
import br.uff.sti.models.Usuario;
import br.uff.sti.services.PostService;
import br.uff.sti.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author leandroribeirodecicco
 */
@Component
@Order(7)
public class Item6Extra extends BaseRunner  {
    
    @Autowired
    PostService postService;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Override
    public void run(String... args) {        
        
        printItemLabel("6 (Extra - Parte 1)");
    
        for (PostComUsuarioDTO post:  postService.getAllWithUsuario()){
            System.out.println(post);
        }        
        
        printItemLabel("6 (Extra - Parte 2)");
        
        Usuario usuario = usuarioService.getLastInserted();        
        for (PostComUsuarioDTO post:  postService.getWithUsuarioByUsuario(usuario)){
            System.out.println(post);
        } 
    }
    
}