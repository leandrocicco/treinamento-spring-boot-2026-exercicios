package br.uff.sti;

import br.uff.sti.csv.implementations.LugarExtractor;
import br.uff.sti.csv.reader.CSVReader;
import br.uff.sti.csv.implementations.PessoaExtractor;
import br.uff.sti.interfaces.Reader;
import br.uff.sti.interfaces.Writer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.uff.sti.json.writer.JSONWriter;
import br.uff.sti.utils.ResourceLoader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
        
        logger.info("Abrindo arquivo dos resources: "+ fileName);    
        
        try (InputStream fileStream = ResourceLoader.loadFile(fileName)) {

//            String csv = """
//                        nome,idade,cpf,curso
//                        leandro,42,10350343799,computação                        
//                         """;
//            Reader reader = new CSVReader(csv, new PessoaExtractor());     
            Reader reader = new CSVReader(fileStream, new PessoaExtractor());
//            Reader reader = new CSVReader(fileStream, new LugarExtractor());

            List<Map<String,Object>> pessoas = reader.read();

            if (!pessoas.isEmpty()){

                logger.info("Exibindo o conteúdo do CSV.");        
                for (Map<String,Object> pessoa: pessoas){            
                    System.out.println(pessoa);
                }

                Writer writer = new JSONWriter(pessoas);
                
                logger.info("Transformando o conteúdo do CSV em JSON.");
                System.out.println(writer.write());
                
                logger.info("Transformando o conteúdo do CSV em JSON e salvando em arquivo output.json na pasta src/main/resources");
                try (OutputStream fileOut = new FileOutputStream("src/main/resources/output.json")) {
                    writer.write(fileOut);
                } 
                catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }               
                
            }
            else{
                logger.info("Nenhuma informação extraída do arquivo: " + fileName);
            }
        
        }   
        catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        
    }
    
}