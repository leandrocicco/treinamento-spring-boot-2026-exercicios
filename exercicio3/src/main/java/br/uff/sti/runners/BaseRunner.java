package br.uff.sti.runners;
import org.springframework.boot.CommandLineRunner;

/**
 *
 * @author leandroribeirodecicco
 */
public abstract class BaseRunner implements CommandLineRunner{
    
    public void printItemLabel(String itemName){
        String item = """
        =========================================================
        | Item: %s        
        =========================================================
        """.formatted(itemName);
        
        System.out.println(item);
    } 

}
