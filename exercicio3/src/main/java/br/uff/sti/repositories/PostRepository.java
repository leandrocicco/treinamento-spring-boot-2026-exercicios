package br.uff.sti.repositories;

import br.uff.sti.models.Post;
import br.uff.sti.models.Usuario;
import br.uff.sti.models.dto.PostComUsuarioDTO;
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
    
    @Query("SELECT P.ID, P.DATA_POSTAGEM, P.MENSAGEM, " +
            "U.ID AS ID_USUARIO, U.NOME AS NOME_USUARIO, " +
            "U.USERNAME AS USERNAME_USUARIO, U.IDADE AS IDADE_USUARIO " +
            "FROM POST P " +
            "INNER JOIN USUARIO U ON P.USUARIO_ID = U.ID")
    List<PostComUsuarioDTO> findAllWithUsuario();
    
    @Query("SELECT P.ID, P.DATA_POSTAGEM, P.MENSAGEM, " +
            "U.ID AS ID_USUARIO, U.NOME AS NOME_USUARIO, " +
            "U.USERNAME AS USERNAME_USUARIO, U.IDADE AS IDADE_USUARIO " +
            "FROM POST P " +
            "INNER JOIN USUARIO U ON P.USUARIO_ID = U.ID " +
            "WHERE U.ID = :id")
    List<PostComUsuarioDTO> findWtihUsuarioByUsuarioId(Long id);
    
}

