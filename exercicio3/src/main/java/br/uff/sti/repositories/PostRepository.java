package br.uff.sti.repositories;

import br.uff.sti.models.Post;
import br.uff.sti.models.Usuario;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author leandroribeirodecicco
 */

public interface PostRepository extends CrudRepository<Post, Long> {
    
    /* Por padrão o Spring Data JDBC faz N+1 queries em collection aggregated entities*/
    
    List<Post> findTop5ByUsuarioOrderByDataPostagemDesc(AggregateReference<Usuario, Long> usuario);
    
    @Query("SELECT p.* FROM post p " +
        "INNER JOIN post_tag tag ON p.id = tag.post_id " +
        "WHERE tag.nome = :tagName " +
        "ORDER BY p.data_postagem desc limit :qtd")
    List<Post> findTopNByTagNameOrderByDataPostagemDesc(String tagName, int qtd);
    
    List<Post> findByMensagemContainingIgnoreCaseOrderByDataPostagemDesc(String word);
    
    Stream <Post> findTop15ByOrderByDataPostagemDesc();
    
}

