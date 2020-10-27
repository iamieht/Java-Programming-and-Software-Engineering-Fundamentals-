
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
    
    public int getRank (int year, String name, String gender) {
        String fname = "us_babynames/us_babynames_test/yob" + year + "short.csv";
        FileResource fr = new FileResource(fname);
        CSVParser parser = fr.getCSVParser(false);
        int rank = -1;
        int counterF = 0;
        int counterM = 0;
        
        for (CSVRecord record : parser) {
            if (record.get(1).equals("F")) {
                counterF += 1;
                if (record.get(0).equals(name) && record.get(1).equals(gender)) {
                    rank = counterF;
                    return rank;
                }
            }
            else {
                counterM += 1;
                if (record.get(0).equals(name) && record.get(1).equals(gender)) {
                    rank = counterM;
                    return rank;
                }
            }    
        
        }
        return rank;
    }
    
    public String getName(int year, int rank, String gender) {
        String fname = "us_babynames/us_babynames_test/yob" + year + "short.csv";
        FileResource fr = new FileResource(fname);
        CSVParser parser = fr.getCSVParser(false);
        int counterF = 0;
        int counterM = 0;
        
        for (CSVRecord record : parser) {
            if (record.get(1).equals("F")) {
                counterF += 1;
                if (record.get(1).equals(gender) && rank == counterF) {
                    return record.get(0);
                }
  
            }
            else {
                counterM += 1;
                if (record.get(1).equals(gender) && rank == counterM) {
                    return record.get(0);
                }
            }
        }
        return "NO NAME";
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender) {
        int nameRank = getRank(year, name, gender);
        String newName = getName(newYear, nameRank, gender);
        
        System.out.println(name + " born in " + year + " would be " + newName + 
                            " if she was born in " + newYear);
    }
    
    public void testTotalBirths () {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    
    public void testGetRank() {
        int rank = getRank(2012, "Sophia", "F");
        System.out.println("The rank of Sophia (F) in 2012 is: " + rank);
        rank = getRank(2012, "Isabella", "F");
        System.out.println("The rank of Isabella (F) in 2012 is: " + rank);
        rank = getRank(2012, "Noah", "M");
        System.out.println("The rank of Noah (M) in 2012 is: " + rank);
        rank = getRank(2012, "Mason", "M");
        System.out.println("The rank of Mason (M) in 2012 is: " + rank);
        rank = getRank(2012, "Mason", "F");
        System.out.println("The rank of Mason (F) in 2012 is: " + rank);
    }
    
    public void testGetName() {
        String name = getName(2012, 1, "F");
        System.out.println("The number 1 ranked female name in 2012 was: " + name);
        name = getName(2012, 4, "M");
        System.out.println("The number 4 ranked male name in 2012 was: " + name);
        name = getName(2012, 6, "M");
        System.out.println("The number 6 ranked male name in 2012 was: " + name);
    }
    
    public void testWhatIsNameInYear () {
        whatIsNameInYear("Isabella", 2012, 2014, "F");
    }
}
