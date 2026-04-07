package br.uff.sti.repositories;

import br.uff.sti.models.Usuario;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author leandroribeirodecicco
 */

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    
    Usuario findFirst1ByOrderByIdDesc();
    
}

