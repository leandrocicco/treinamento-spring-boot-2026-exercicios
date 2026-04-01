package br.uff.sti.writer.csv;

import br.uff.sti.annotations.Loga;
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
@Component("infoWriter")
public class CSVInfoWriter extends CSVWriter {

    private static final Logger logger = LoggerFactory.getLogger(CSVInfoWriter.class);

    @Loga
    @Override
    public void write(List<Map<String, String>> list, Destination destination, boolean writeHeader) {        
        super.write(list, destination, writeHeader);
    }

}
