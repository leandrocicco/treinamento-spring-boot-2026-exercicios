package br.uff.sti.runners;

import br.uff.sti.models.Post;
import br.uff.sti.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author leandroribeirodecicco
 */
@Component
@Order(4)
public class Item3 implements CommandLineRunner {
    
    @Autowired
    PostService postService;
    
    @Override
    public void run(String... args) {        
        
        String item = """
        =========================================================
        | Item: %s        
        =========================================================
        """.formatted(3);
        
        System.out.println(item);
        
        for (Post post: postService.getLastNPostsWithTag("rpg", 10)) {            
            System.out.println(post);
        }
        
    }
    
}