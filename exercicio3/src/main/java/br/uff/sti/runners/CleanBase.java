package br.uff.sti.runners;

import br.uff.sti.services.PostService;
import br.uff.sti.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author leandroribeirodecicco
 */

@Component
@Order(1)
public class CleanBase extends BaseRunner {
    
    @Autowired
    PostService postService;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Override
    public void run(String... args) {
        
        printItemLabel("Limpando a base de dados...");
        
        postService.deleteAll();
        usuarioService.deleteAll();
    }
}