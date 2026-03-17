package br.uff.sti.csv.reader;

import br.uff.sti.utils.ResourceLoader;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.NamedCsvRecord;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.uff.sti.csv.interfaces.CSVExtractable;
import java.util.Map;

/**
 *
 * @author leandroribeirodecicco
 */
public class CSVReader {
    
    static final Logger logger = LoggerFactory.getLogger(CSVReader.class);
    
    public List<Map<String,Object>> readRecordsFromCSVFile(String fileName, CSVExtractable csvExtractable){
        
        List<Map<String,Object>> records = new ArrayList<>();
        
        try (InputStream fileStream = ResourceLoader.loadFile(fileName)) {
            
            try (CsvReader<NamedCsvRecord> csv = CsvReader.builder().ofNamedCsvRecord(fileStream)) {
                csv.forEach(rec -> records.add(csvExtractable.extractFromCSVRecord(rec).toMap()));
            } 
            
        } 
        catch (IOException | IllegalArgumentException e) {
            logger.error(e.getMessage(), e);
        }
        
        return records;       
    }
    
}
