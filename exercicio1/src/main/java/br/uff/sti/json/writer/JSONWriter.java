package br.uff.sti.json.writer;

import br.uff.sti.interfaces.Writer;
import java.io.OutputStream;
import tools.jackson.databind.ObjectMapper;

/**
 *
 * @author leandroribeirodecicco
 */
public class JSONWriter implements Writer{
    
    private final ObjectMapper jsonMapper = new ObjectMapper();
   
    private Object toJsonObject = null;
    
    public JSONWriter(Object toJsonObject){
        this.toJsonObject = toJsonObject;
    }
    
    public String write(){    
        return jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this.toJsonObject);
    }
    
    public void write(OutputStream outputStream){
        jsonMapper.writerWithDefaultPrettyPrinter().writeValue(outputStream, this.toJsonObject);
    }
    
}
