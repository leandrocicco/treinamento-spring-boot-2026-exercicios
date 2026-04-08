package br.uff.sti.runners;

import br.uff.sti.models.Post;
import br.uff.sti.services.PostService;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author leandroribeirodecicco
 */
@Component
@Order(6)
public class Item5 implements CommandLineRunner {
    
    @Autowired
    PostService postService;
    
    @Override
    public void run(String... args) {        
        
        String item = """
        =========================================================
        | Item: %s        
        =========================================================
        """.formatted(5);
        
        System.out.println(item);
    
        try (Stream<Post> postStream = postService.getLastFifteenPosts()) {
            postStream.forEach(post -> {
                System.out.println(post);
            }); 
        }
    }
    
}