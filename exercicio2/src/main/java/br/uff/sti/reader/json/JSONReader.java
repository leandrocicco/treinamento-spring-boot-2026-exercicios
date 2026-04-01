package br.uff.sti.reader.json;

import br.uff.sti.annotations.Loga;
import br.uff.sti.origin.Origin;
import br.uff.sti.reader.Reader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

/**
 *
 * @author leandroribeirodecicco
 */
@Component
public class JSONReader implements Reader {

    private static final Logger logger = LoggerFactory.getLogger(JSONReader.class);

    @Loga
    public List<Map<String, Object>> read(Origin origin) {
        
        List<Map<String, Object>> list = new ArrayList<>();

        try ( InputStream inputStream = origin.getInputStream()) {
            if (inputStream == null) {
                logger.error("Erro ao abrir o inputStream.");
                return null;
            }

            ObjectMapper mapper = new ObjectMapper();
            
            list = mapper.readValue(inputStream, new TypeReference<List<Map<String, Object>>>() {});

            for (Map<String, Object> map : list) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    logger.debug(entry.getKey() + " = " + entry.getValue());
                }
            }

        } 
        catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        
        return list;

    }

}
