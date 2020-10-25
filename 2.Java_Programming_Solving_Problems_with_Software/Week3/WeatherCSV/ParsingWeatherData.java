
/**
 * Write a description of ParsingWeatherData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class ParsingWeatherData {
    
    public CSVRecord coldestHourInFile(CSVParser parser) {        
        CSVRecord smallestSoFar = null;
        
        for (CSVRecord currentRow : parser) {
            smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar);
        }
        return smallestSoFar;
    }
    
    public CSVRecord getSmallestOfTwo(CSVRecord currentRow, CSVRecord smallestSoFar) {
        if (smallestSoFar == null) {
            smallestSoFar = currentRow;
        }
        else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
            
            if (currentTemp != -9999 && currentTemp < smallestTemp) {
                smallestSoFar = currentRow;
            }
        }
        return smallestSoFar;
    }
    
    public String fileWithColdestTemperature() {
        String filename = "";
        CSVRecord smallestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if (smallestSoFar == null) {
                smallestSoFar = currentRow;
                filename = f.toString();
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
                if (currentTemp != -9999 && currentTemp < smallestTemp) {
                    smallestSoFar = currentRow;
                    filename = f.toString();
                }
            }
        }
        return filename;
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestHumiditySoFar = null;
        
        for (CSVRecord currentRow : parser) {
            lowestHumiditySoFar = getLowestHumidityInTwo(currentRow, lowestHumiditySoFar);
        }
        return lowestHumiditySoFar;
    }
    
    public CSVRecord getLowestHumidityInTwo(CSVRecord currentRow, CSVRecord lowestHumiditySoFar) {
        if (lowestHumiditySoFar == null) {
            lowestHumiditySoFar = currentRow;
        }
        else {
            String currentHumidity = currentRow.get("Humidity");
            String lowestHumidity = lowestHumiditySoFar.get("Humidity");
            
            if (currentHumidity != "N/A" && lowestHumidity != "N/A") {
                int currentHumidityTemp = Integer.parseInt(currentRow.get("Humidity"));
                int lowestHumidityTemp = Integer.parseInt(lowestHumiditySoFar.get("Humidity"));
                
                if (currentHumidityTemp < lowestHumidityTemp){
                    lowestHumiditySoFar = currentRow;
                }                
            }
        }
        return lowestHumiditySoFar;
    }
   
    public void testColdestHourInFile() {
        FileResource fr = new FileResource();
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature was " + coldest.get("TemperatureF") +
                            "F" + " at " + coldest.get("TimeEST"));
    }
    
    public void testFileWithColdestTemperature() {
        String filename = fileWithColdestTemperature();
        System.out.println("File with coldest temperature is " + filename);
        FileResource fr = new FileResource(filename);
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature on that day was " + coldest.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were:");
        for (CSVRecord currentRow : fr.getCSVParser()) {
            System.out.println( currentRow.get("DateUTC") + ": " + currentRow.get("TemperatureF"));
        }
    }
    
    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest humidity was " + csv.get("Humidity") +
                            " at " + csv.get("DateUTC"));
    }
}
