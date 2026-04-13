package br.uff.exercicio4.repository;

import br.uff.exercicio4.modelo.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Long>,
        CrudRepository<Post, Long> {
}
