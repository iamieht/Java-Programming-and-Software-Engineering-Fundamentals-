
/**
 * Write a description of WhichCountriesExport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class WhichCountriesExport {
    
    public void listExporters(CSVParser parser, String exportOfInterest) {
        for(CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportOfInterest)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    public String countryInfo(CSVParser parser, String country) {
        String fullRecord = "";
        for(CSVRecord record : parser) {
            String countryColumn = record.get("Country");
            if (countryColumn.contains(country)) {
                String export = record.get("Exports");
                String value = record.get("Value (dollars)");
                return country + ": " + export + ": " + value;
            }
        }
        return "NOT FOUND";
    }
    public void whoExportsCoffee() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffee");
    }
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        String fullRecord = countryInfo(parser, "Germany");
        System.out.println(fullRecord);
    }
}
