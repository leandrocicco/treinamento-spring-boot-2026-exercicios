package br.uff.sti.services;

import br.uff.sti.models.Post;
import br.uff.sti.models.Usuario;
import br.uff.sti.repositories.PostRepository;
import jakarta.validation.ConstraintViolation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import jakarta.validation.Validator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 *
 * @author leandroribeirodecicco
 */

@Service
@AllArgsConstructor
public class PostService {

    private final Validator validator;

    private final PostRepository postRepository;
    
    @Transactional
    public Post saveWithCurrentDateOnDataPostagem(Post post){
        post = post.withDataPostagem(LocalDateTime.now());
        return this.save(post);
    }
    
    @Transactional
    public Post save(Post post){
        assert post.id() == null;        

        final Set<ConstraintViolation<Post>> violations = validator.validate(post);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Objeto inválido: " + violations);
        }

        return postRepository.save(post);
    }
    
    public List<Post> getLastFivePostsFromUser(Usuario usuario){
        return postRepository.findTop5ByUsuarioOrderByDataPostagemDesc(AggregateReference.to(usuario.id()));
    }
    
    public List<Post> getLastNPostsWithTag(String tagName, int qtdPosts){
        return postRepository.findTopNByTagNameOrderByDataPostagemDesc(tagName, qtdPosts);
    }
    
    public List<Post> getAllByMensagemContainingCaseInsensitive(String word){
        return postRepository.findByMensagemContainingIgnoreCaseOrderByDataPostagemDesc(word);
    }
    
    @Transactional(readOnly = true)
    public Stream<Post> getLastFifteenPosts(){
        return postRepository.findTop15ByOrderByDataPostagemDesc();        
    }
    
    @Transactional
    public void deleteAll(){
        postRepository.deleteAll();
    }
}

