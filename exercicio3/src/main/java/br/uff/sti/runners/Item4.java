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
@Order(5)
public class Item4 implements CommandLineRunner {
    
    @Autowired
    PostService postService;
    
    @Override
    public void run(String... args) {        
        
        String item = """
        =========================================================
        | Item: %s        
        =========================================================
        """.formatted(4);
        
        System.out.println(item);
        
        for (Post post: postService.getAllByMensagemContainingCaseInsensitive("orc")) {            
            System.out.println(post);
        }
        
    }
    
}