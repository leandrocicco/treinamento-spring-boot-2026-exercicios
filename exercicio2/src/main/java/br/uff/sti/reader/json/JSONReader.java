package br.uff.sti.reader.json;

import br.uff.sti.interfaces.Reader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;

import tools.jackson.databind.ObjectMapper;

/**
 *
 * @author leandroribeirodecicco
 */
@Component("jsonReader")
public class JSONReader implements Reader {

    private static final Logger logger = LoggerFactory.getLogger(JSONReader.class);

    private final String jsonInputFileName;

    private final ResourceLoader resourceLoader;

    public JSONReader(@Value("${json.input.filename:input.json}") String jsonInputFileName,
            ResourceLoader resourceLoader) {
        this.jsonInputFileName = jsonInputFileName;
        this.resourceLoader = resourceLoader;
    }

    public List<Map<String, Object>> read() {
        
        List<Map<String, Object>> list = new ArrayList<>();
        
        Resource resource = resourceLoader.getResource("classpath:" + jsonInputFileName);

        try ( InputStream inputStream = resource.getInputStream()) {
            if (inputStream == null) {
                logger.error("Arquivo " + this.jsonInputFileName + "não encontrado no classpath (src/main/resource).");
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
