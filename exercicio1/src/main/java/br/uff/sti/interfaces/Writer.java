package br.uff.sti.interfaces;

import java.io.OutputStream;

/**
 *
 * @author leandroribeirodecicco
 */
public interface Writer {
    
    public String write();
    
    public void write(OutputStream outputStream);
    
}
