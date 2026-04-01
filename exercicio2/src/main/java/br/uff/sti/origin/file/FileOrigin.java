package br.uff.sti.origin.file;

import br.uff.sti.origin.Origin;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 *
 * @author leandroribeirodecicco
 */
public class FileOrigin implements Origin {

    private final String filenNme;

    private final ResourceLoader resourceLoader;
    
    public FileOrigin(String filenNme, ResourceLoader resourceLoader) {
        this.filenNme = filenNme;
        this.resourceLoader = resourceLoader;
    }    
    
    @Override
    public InputStream getInputStream() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + this.filenNme);
       return resource.getInputStream();
    }
    
}
