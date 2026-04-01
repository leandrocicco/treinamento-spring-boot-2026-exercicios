package br.uff.sti;

import br.uff.sti.destination.Destination;
import br.uff.sti.origin.Origin;
import br.uff.sti.processor.Processor;
import br.uff.sti.reader.Reader;
import br.uff.sti.writer.Writer;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("Iniciando aplicação Spring-Boot");
        try ( var context = SpringApplication.run(Application.class, args)) {

        }
        logger.info("Finalizando aplicação Spring-Boot");
    }

    @Autowired
    public Reader reader;

    @Autowired
    public Processor processor;

    @Autowired
    public Writer infoWriter;

    @Bean
    public CommandLineRunner execute(Origin mainOrigin, Destination mainDestination) {
        return (args) -> {            

            List<Map<String, Object>> list = reader.read(mainOrigin);

            var newList = processor.processList(
                    list,
                    (Object obj) -> {
                        if (obj == null) {
                            return "";
                        } else if (obj instanceof String string) {
                            return string.toUpperCase();
                        } else {
                            return obj.toString();
                        }
                    }
            );

            infoWriter.write(newList, mainDestination, true);

        };
    }

}
