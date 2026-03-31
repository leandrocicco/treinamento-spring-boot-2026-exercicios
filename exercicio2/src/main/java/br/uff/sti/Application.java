package br.uff.sti;

import br.uff.sti.interfaces.Processor;
import br.uff.sti.interfaces.Reader;
import br.uff.sti.interfaces.Writer;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    
    public static void main(String[] args) {
        logger.info("Iniciando aplicação Spring-Boot");
        try(var context = SpringApplication.run(Application.class, args)){
            
        }
        logger.info("Finalizando aplicação Spring-Boot");
    }   
    
    @Autowired
    public Reader jsonReader;

    @Autowired
    public Processor processor;
    
    @Autowired
    public Writer csvWriter;

    @Override
    public void run(String... args) throws Exception {
        
        System.out.println("CommandLineRunner executed with arguments:");
        for (String arg : args) {
            System.out.println(arg);
        }


        List<Map<String, Object>> list = jsonReader.read();

        var newList = processor.processList(
                list,
                (Object obj) -> {
                    if(obj == null){
                        return "";
                    }
                    else if (obj instanceof String string) {
                        return string.toUpperCase();
                    }
                    else {
                        return obj.toString();
                    }                    
                }
        );

        for (Map<String, String> map : newList) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        }
        
        csvWriter.write(newList);
        
    }       

}
