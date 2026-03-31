package br.uff.sti.interfaces;

import java.util.List;
import java.util.Map;

/**
 *
 * @author leandroribeirodecicco
 */
public interface Processor {
    
    public List<Map<String, String>> processList(List<Map<String, Object>> list, Processable processable);
    
}
