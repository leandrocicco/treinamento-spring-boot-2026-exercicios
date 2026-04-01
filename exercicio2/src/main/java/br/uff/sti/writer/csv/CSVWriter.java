package br.uff.sti.writer.csv;

import br.uff.sti.destination.Destination;
import br.uff.sti.writer.Writer;
import de.siegmar.fastcsv.writer.CsvWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author leandroribeirodecicco
 */

public abstract class CSVWriter implements Writer {

    private static final Logger logger = LoggerFactory.getLogger(CSVWriter.class);
    
    public void write(List<Map<String, String>> list, Destination destination, boolean writeHeader) {
        
        try (OutputStream outputStream = destination.getOutputStream()) {            
            
            try (CsvWriter csv = CsvWriter.builder().build(outputStream)) {
                
                if (!list.isEmpty()) {
                    if (writeHeader) {
                        Map<String, String> firstMap = list.getFirst();
                        csv.writeRecord(firstMap.keySet());
                        logger.info(String.join(",", firstMap.keySet()));
                    }
                
                    for (Map<String, String> map : list) {
                        csv.writeRecord(map.values());
                        logger.info(String.join(",", map.values()));
                    }
                }                
            }
            
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

    }

}
