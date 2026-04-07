package br.uff.sti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author leandroribeirodecicco
 */
@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        log.info("Iniciando aplicação Spring-Boot");
        try ( var context = SpringApplication.run(Application.class, args)) {

        }
        log.info("Finalizando aplicação Spring-Boot");
    }

}
