package br.uff.sti.process;

import br.uff.sti.interfaces.Processable;
import br.uff.sti.interfaces.Processor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author leandroribeirodecicco
 */
@Component("processor")
public class ProcessorImpl implements Processor {

    private static final Logger logger = LoggerFactory.getLogger(ProcessorImpl.class);    

    public List<Map<String, String>> processList(List<Map<String, Object>> list, Processable processable) {
        List<Map<String, String>> newList = new ArrayList<>();
        for (Map<String, Object> map : list) {
            Map<String, String> newMap = new LinkedHashMap<>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                newMap.put(entry.getKey(), processable.processValue(entry.getValue()));                
            }
            newList.add(newMap);
        }
        return newList;
    }
    
    

}
