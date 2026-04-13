package br.uff.exercicio4.repository;

import br.uff.exercicio4.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
