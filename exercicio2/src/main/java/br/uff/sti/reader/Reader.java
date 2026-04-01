package br.uff.sti.reader;

import br.uff.sti.origin.Origin;
import java.util.List;
import java.util.Map;

/**
 *
 * @author leandroribeirodecicco
 */
public interface Reader {    
    
    public List<Map<String, Object>> read(Origin origin);

}
