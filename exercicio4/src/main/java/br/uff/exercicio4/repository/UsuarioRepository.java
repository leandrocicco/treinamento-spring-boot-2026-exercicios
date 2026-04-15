package br.uff.exercicio4.repository;

import br.uff.exercicio4.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>,CrudRepository<Usuario, Long> {
}
