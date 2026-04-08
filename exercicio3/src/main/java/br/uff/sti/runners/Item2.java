package br.uff.sti.runners;

import br.uff.sti.models.Post;
import br.uff.sti.models.Usuario;
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
@Order(3)
public class Item2 extends BaseRunner {
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    PostService postService;
    
    @Override
    public void run(String... args) {
        
        printItemLabel("2");
        
        Usuario usuario = usuarioService.getLastInserted();
        System.out.println(usuario);
        for (Post post: postService.getLastFivePostsFromUser(usuario)) {            
            System.out.println(post);
        }
        
    }
    
}