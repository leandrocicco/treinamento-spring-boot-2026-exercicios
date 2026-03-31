package br.uff.sti.writer.csv;

import br.uff.sti.interfaces.Writer;
import de.siegmar.fastcsv.writer.CsvWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author leandroribeirodecicco
 */
@Component("csvWriter")
public class CSVWriter implements Writer {

    private static final Logger logger = LoggerFactory.getLogger(CSVWriter.class);

    private final String csvOutputFileName;   
    

    public CSVWriter(@Value("${csv.output.filename:output.csv}") String csvOutputFileName) {
        this.csvOutputFileName = csvOutputFileName;        
    }

    public void write(List<Map<String, String>> list) {
    
        String filePath = "src/main/resources/" + csvOutputFileName;
        
        try (OutputStream fileOut = new FileOutputStream(filePath)) {
            
            try (CsvWriter csv = CsvWriter.builder().build(fileOut)) {
                
                if (!list.isEmpty()) {
                    Map<String, String> firstMap = list.getFirst();
                    csv.writeRecord(firstMap.keySet());                
                
                    for (Map<String, String> map : list) {
                        csv.writeRecord(map.values());
                    }
                }                
            }
            
            logger.info("Arquivo CSV criado em: " + filePath);
            
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

    }

}
