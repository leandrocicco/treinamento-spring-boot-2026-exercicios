package br.uff.sti.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author leandroribeirodecicco
 */
public class Utils {

    public static String getDataHoraAtualFormatada(){
        LocalDateTime agora = LocalDateTime.now();

        // Define o formato PT-BR
        DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("dd/MM/yyyy HH:mm:ss")
            .withLocale(Locale.of("pt", "BR"));

        // Formata e imprime
        return agora.format(formatter);
    }
    
}
