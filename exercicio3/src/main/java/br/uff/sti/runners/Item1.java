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
@Order(2)
public class Item1 extends BaseRunner {
    
    public static final int QTD_USUARIOS = 5;
    public static final int QTD_POST_POR_USUARIO = 6;
    
    
    @Autowired
    PostService postService;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Override
    public void run(String... args) {
        
        printItemLabel("1");
        
        for(int i = 0; i < QTD_USUARIOS; i++) {            
            Usuario usuario = usuarioService.save(Usuario.fake());
            for(int j = 0; j < QTD_POST_POR_USUARIO; j++) {
                Post post = postService.save(Post.fake(usuario));
            }
        }
        
        System.out.println("Usuários salvos: " + QTD_USUARIOS);
        System.out.println("Posts salvos: " + (QTD_USUARIOS*QTD_POST_POR_USUARIO) + "\n");
        
    }
    
}