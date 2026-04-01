package br.uff.sti.destination;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author leandroribeirodecicco
 */
public interface Destination {
    
    public OutputStream getOutputStream() throws IOException;
    
}
