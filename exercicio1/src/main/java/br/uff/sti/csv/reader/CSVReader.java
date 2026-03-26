package br.uff.sti.csv.reader;

import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.NamedCsvRecord;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.uff.sti.csv.interfaces.CSVExtractable;
import br.uff.sti.interfaces.Reader;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 *
 * @author leandroribeirodecicco
 */
public class CSVReader implements Reader {
    
    static final Logger logger = LoggerFactory.getLogger(CSVReader.class);
    
    private InputStream inputStream = null;
    private CSVExtractable csvExtractable = null;       
    
    public CSVReader(InputStream inputStream, CSVExtractable csvExtractable){
        this.inputStream = inputStream;
        this.csvExtractable = csvExtractable;
    }
    
    public CSVReader(String str, CSVExtractable csvExtractable){
        this.inputStream = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
        this.csvExtractable = csvExtractable;
    }
    
    public List<Map<String,Object>> read(){
        
        List<Map<String,Object>> records = new ArrayList<>();
        
        try (CsvReader<NamedCsvRecord> csv = CsvReader.builder().ofNamedCsvRecord(this.inputStream)) {
                csv.forEach(rec -> records.add(this.csvExtractable.extractFromCSVRecord(rec).toMap()));
        }
        catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        
        return records;       
    }  
    
}
