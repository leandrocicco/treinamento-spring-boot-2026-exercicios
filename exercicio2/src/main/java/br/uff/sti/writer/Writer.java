package br.uff.sti.writer;

import br.uff.sti.destination.Destination;
import java.util.List;
import java.util.Map;

/**
 *
 * @author leandroribeirodecicco
 */
public interface Writer {
    
    public void write(List<Map<String, String>> list, Destination destination, boolean writeHeader);
    
}
