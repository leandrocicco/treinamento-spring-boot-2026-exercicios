package br.uff.sti.writer.csv;

import br.uff.sti.destination.Destination;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author leandroribeirodecicco
 */
@Component("logWriter")
public class CSVLogWriter extends CSVWriter {

    private static final Logger logger = LoggerFactory.getLogger(CSVLogWriter.class);
    
    @Override
    public void write(List<Map<String, String>> list, Destination destination, boolean writeHeader) {        
        super.write(list, destination, writeHeader);
    }

}
