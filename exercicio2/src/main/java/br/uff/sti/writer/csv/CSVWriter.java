package br.uff.sti.writer.csv;

import br.uff.sti.annotations.Loga;
import br.uff.sti.destination.Destination;
import br.uff.sti.writer.Writer;
import de.siegmar.fastcsv.writer.CsvWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author leandroribeirodecicco
 */
@Component
public class CSVWriter implements Writer {

    private static final Logger logger = LoggerFactory.getLogger(CSVWriter.class);

    @Loga
    @Override
    public void write(List<Map<String, String>> list, Destination destination) {
        try ( OutputStream outputStream = destination.getOutputStream()) {

            try ( CsvWriter csv = CsvWriter.builder().build(outputStream)) {

                if (!list.isEmpty()) {                    
                    Map<String, String> firstMap = list.getFirst();
                    csv.writeRecord(firstMap.keySet());
                    logger.info(String.join(",", firstMap.keySet()));                    

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

    @Override
    public void log(List<String> list, Destination destination) {
        
        try ( OutputStream outputStream = destination.getOutputStream()) {

            try ( CsvWriter csv = CsvWriter.builder().build(outputStream)) {

                if (!list.isEmpty()) {
             
                    csv.writeRecord(list);
                    logger.info(String.join(",", list));
        
                }
            }

        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }   

}
