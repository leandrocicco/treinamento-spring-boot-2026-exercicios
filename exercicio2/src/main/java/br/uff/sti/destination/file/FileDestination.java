package br.uff.sti.destination.file;

import br.uff.sti.destination.Destination;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author leandroribeirodecicco
 */
public class FileDestination implements Destination {

    private final String fileName;
    private final boolean append;    

    public FileDestination(String fileName) {
        this.fileName = fileName;
        this.append = false;
    }
    public FileDestination(String fileName, boolean append) {
        this.fileName = fileName;
        this.append = append;
    }    
    
    @Override
    public OutputStream getOutputStream() throws IOException {
         String filePath = "src/main/resources/" + this.fileName;        
        return new FileOutputStream(filePath, this.append);
    }
    
}
