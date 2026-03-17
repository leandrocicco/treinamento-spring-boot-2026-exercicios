package br.uff.sti.csv.implementations;

import de.siegmar.fastcsv.reader.NamedCsvRecord;
import br.uff.sti.csv.interfaces.CSVExtractable;
import br.uff.sti.csv.interfaces.CSVMappable;

/**
 *
 * @author leandroribeirodecicco
 */
public class PessoaExtractor implements CSVExtractable {
    
    @Override
    public CSVMappable extractFromCSVRecord(final NamedCsvRecord rec){
        return new Pessoa(
            rec.getField("nome"),        
            Integer.valueOf(rec.getField("idade")),
            rec.getField("cpf"),
            rec.getField("curso")
        );
    }
    
}
