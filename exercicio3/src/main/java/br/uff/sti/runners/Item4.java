package br.uff.sti.runners;

import br.uff.sti.models.Post;
import br.uff.sti.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author leandroribeirodecicco
 */
@Component
@Order(5)
public class Item4 extends BaseRunner {
    
    @Autowired
    PostService postService;
    
    @Override
    public void run(String... args) {        
        
        printItemLabel("4");
        
        for (Post post: postService.getAllByMensagemContainingCaseInsensitive("orc")) {            
            System.out.println(post);
        }
        
    }
    
}