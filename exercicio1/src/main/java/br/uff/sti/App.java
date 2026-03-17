package br.uff.sti;

import br.uff.sti.csv.reader.CSVReader;
import br.uff.sti.csv.implementations.PessoaExtractor;
import tools.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.uff.sti.csv.interfaces.CSVExtractable;
import java.util.List;
import java.util.Map;

public class App {
    
    static final Logger logger = LoggerFactory.getLogger(App.class);
    
    public static void main( String[] args) {

        if (args.length < 1) {
            logger.error("Execute o programa passando o nome do CSV como argumento. O CSV deve estar na pasta src/main/resources.");
            return;
        }
        
        String fileName = args[0];
        
        logger.info("Lendo o CSV dos resources: "+ fileName);        
        CSVExtractable csvExtractor = new PessoaExtractor();        
        CSVReader csvReader = new CSVReader();
        List<Map<String,Object>> pessoas = csvReader.readRecordsFromCSVFile(fileName, csvExtractor);
        
        if (!pessoas.isEmpty()){
            
            logger.info("Exibindo o conteúdo do CSV.");        
            for (Map<String,Object> pessoa: pessoas){            
                System.out.println(pessoa);
            }

            logger.info("Transformando o conteúdo do CSV em JSON.");
            ObjectMapper jsonMapper = new ObjectMapper();
            String jsonOutput = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pessoas);
            System.out.println(jsonOutput);
            
        }
        
    }
    
}
