package br.uff.sti.runners;

import br.uff.sti.services.PostService;
import br.uff.sti.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author leandroribeirodecicco
 */

@Component
@Order(1)
public class CleanBase implements CommandLineRunner {
    
    @Autowired
    PostService postService;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Override
    public void run(String... args) {
        postService.deleteAll();
        usuarioService.deleteAll();
        
        System.out.println("\n\nLimpando a base de dados...\n\n");
    }
}