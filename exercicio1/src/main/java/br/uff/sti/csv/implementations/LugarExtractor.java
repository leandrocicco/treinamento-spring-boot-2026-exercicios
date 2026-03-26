package br.uff.sti.csv.implementations;

import de.siegmar.fastcsv.reader.NamedCsvRecord;
import br.uff.sti.csv.interfaces.CSVExtractable;
import br.uff.sti.csv.interfaces.CSVMappable;

/**
 *
 * @author leandroribeirodecicco
 */
public class LugarExtractor implements CSVExtractable {
    
    @Override
    public CSVMappable extractFromCSVRecord(final NamedCsvRecord rec){
        return new Lugar(
            rec.getField("nome"),        
            rec.getField("endereco")
        );
    }
    
}
