package br.uff.sti.csv.implementations;

import lombok.With;
import br.uff.sti.csv.interfaces.CSVMappable;
import java.util.LinkedHashMap;
import java.util.Map;

@With
public record Pessoa (String nome, Integer idade, String cpf, String curso) implements CSVMappable {
    
    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("nome", nome());
        map.put("idade", idade());
        map.put("cpf", cpf());
        map.put("curso", curso());
        return map;
    }
}

