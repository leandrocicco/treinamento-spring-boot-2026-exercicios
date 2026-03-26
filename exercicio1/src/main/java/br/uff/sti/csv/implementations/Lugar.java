package br.uff.sti.csv.implementations;

import br.uff.sti.csv.interfaces.CSVMappable;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.With;

/**
 *
 * @author leandroribeirodecicco
 */
@With
public record Lugar (String nome, String endereco) implements CSVMappable {
    
    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("nome", nome());
        map.put("endereco", endereco());        
        return map;
    }
}