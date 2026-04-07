package br.uff.sti.runners;

import br.uff.sti.models.Post;
import br.uff.sti.models.Usuario;
import br.uff.sti.services.PostService;
import br.uff.sti.services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author leandroribeirodecicco
 */
@Component
@Order(3)
public class Item2 implements CommandLineRunner {
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    PostService postService;
    
    @Override
    public void run(String... args) {
        
        String item = """
        =========================================================
        | Item: %s        
        =========================================================
        """.formatted(2);
        
        System.out.println(item);
        
        Usuario usuario = usuarioService.getLastInserted();
        System.out.println(usuario);
        for (Post post: postService.getLastFivePostsFromUser(usuario)) {            
            System.out.println(post);
        }
        
    }
    
}