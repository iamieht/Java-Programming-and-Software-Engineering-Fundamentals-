
/**
 * Write a description of BabyNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyNames {
    public void readOneFile(int year) {
        String fname = "data/yob" + year + ".txt";
        FileResource fr = new FileResource(fname);
        CSVParser parser = fr.getCSVParser(false);
        for (CSVRecord record : parser) {
            String name = record.get(0);
            String gender = record.get(1);
        }
    }
    
    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int totalNames = 0;
        int totalGirlNames = 0;
        int totalBoyNames = 0;
        for (CSVRecord record : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(record.get(2));
            totalBirths += numBorn;
            totalNames += 1;
            if (record.get(1).equals("M")) {
                totalBoys += numBorn;
                totalBoyNames += 1;
            }
            else {
                totalGirls += numBorn;
                totalGirlNames += 1;
            }
        }
        System.out.println("Total births = " + totalBirths);
        System.out.println("Total girls = " + totalGirls);
        System.out.println("Total boys = " + totalBoys);
        System.out.println("Total names = " + totalNames);
        System.out.println("Total girl names = " + totalGirlNames);
        System.out.println("Total boy names = " + totalBoyNames);
    }
    
    public void testTotalBirths () {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
}
