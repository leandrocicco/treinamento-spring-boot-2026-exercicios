package br.uff.sti.origin;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author leandroribeirodecicco
 */
public interface Origin {
    
    public InputStream getInputStream() throws IOException;
    
}
