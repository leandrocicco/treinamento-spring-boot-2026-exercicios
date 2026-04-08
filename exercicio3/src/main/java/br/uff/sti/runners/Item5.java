package br.uff.sti.runners;

import br.uff.sti.models.Post;
import br.uff.sti.services.PostService;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author leandroribeirodecicco
 */
@Component
@Order(6)
public class Item5 extends BaseRunner  {
    
    @Autowired
    PostService postService;
    
    @Override
    public void run(String... args) {        
        
        printItemLabel("5");       
    
        try (Stream<Post> postStream = postService.getLastFifteenPosts()) {
            postStream.forEach(post -> {
                System.out.println(post);
            }); 
        }
    }
    
}