package br.uff.sti.csv.interfaces;

import de.siegmar.fastcsv.reader.NamedCsvRecord;

/**
 *
 * @author leandroribeirodecicco
 */
public interface CSVExtractable {
    
    public CSVMappable extractFromCSVRecord(final NamedCsvRecord rec);
    
}
