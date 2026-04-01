package br.uff.sti;

import br.uff.sti.destination.file.FileDestination;
import br.uff.sti.destination.Destination;
import br.uff.sti.origin.Origin;
import br.uff.sti.origin.file.FileOrigin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

/**
 *
 * @author leandroribeirodecicco
 */
@Configuration
public class CustomConfiguration {

    @Bean("mainOirigin")
    public Origin createMainOrigin(@Value("${json.input.filename:input.json}") String mainJsonFileName, ResourceLoader resourceLoader) {
        return new FileOrigin(mainJsonFileName, resourceLoader);
    }
    
    @Bean("mainDestination")
    public Destination createMainDestination(@Value("${csv.output.filename:output.csv}") String mainCsvFileName) {
        return new FileDestination(mainCsvFileName);
    }
    
    @Bean("logDestination")
    public Destination createLogDestination(@Value("${csv.output.log.filename:output.csv}") String logCsvFileName) {
        return new FileDestination(logCsvFileName, true);
    }

}
