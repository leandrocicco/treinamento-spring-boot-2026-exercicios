package br.uff.sti.utils;

import java.io.InputStream;

/**
 *
 * @author leandroribeirodecicco
 */
public class ResourceLoader {

    public static InputStream loadFile(String filename) {
        InputStream inputStream = ResourceLoader.class.getResourceAsStream("/"+filename);
        
        if (inputStream == null) {
            throw new IllegalArgumentException("Arquivo não encontrado no classpath: " + filename);
        }
        
        return inputStream; 
    }
    
}
