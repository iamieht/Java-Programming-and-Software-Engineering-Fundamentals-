
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
        String fname = "us_babynames/us_babynames_by_year/yob" + year + ".csv";
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
        String fname = "us_babynames/us_babynames_by_year/yob" + year + ".csv";
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
    
    public int yearOfHighestRank(String name, String gender) {
        int finalYear = -1;
        int highestRank = 999999999;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            String fname = f.toString();
            String yearTemp = fname.substring(fname.indexOf("yob") + 3, fname.indexOf("yob") + 7);
            int year = Integer.parseInt(yearTemp);
            int currentRank = getRank(year, name, gender);
            if (currentRank != -1 && currentRank < highestRank) {
                highestRank = currentRank;
                finalYear = year;
            }
        }
        return finalYear;
    }
    
    public double getAverageRank(String name, String gender) {
        double rank = 0.0;
        int count = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            String fname = f.toString();
            String yearTemp = fname.substring(fname.indexOf("yob") + 3, fname.indexOf("yob") + 7);
            int year = Integer.parseInt(yearTemp);
            rank += getRank(year, name, gender);
            count++;
        }
        return rank / count;
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        int controlRank = getRank(year, name, gender);
        int totalBirths = 0;
        String fname = "us_babynames/us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(fname);
        CSVParser parser = fr.getCSVParser(false);
        for (CSVRecord record : parser) {
            if (record.get(1).equals(gender)) {
                int rank = getRank(year, record.get(0), gender);
                if (rank < controlRank) {
                    totalBirths += Integer.parseInt(record.get(2));
                }
            }
        }
        return totalBirths;
    }
    
    public void testTotalBirths () {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    
    public void testGetRank() {
        int rank = getRank(1960, "Emily", "F");
        System.out.println("The rank of Emily (F) in 1960 is: " + rank);
        rank = getRank(1971, "Frank", "M");
        System.out.println("The rank of Frank (M) in 1971 is: " + rank);
        //rank = getRank(2012, "Noah", "M");
        //System.out.println("The rank of Noah (M) in 2012 is: " + rank);
        //rank = getRank(2012, "Mason", "M");
        //System.out.println("The rank of Mason (M) in 2012 is: " + rank);
        //rank = getRank(2012, "Mason", "F");
        //System.out.println("The rank of Mason (F) in 2012 is: " + rank);
    }
    
    public void testGetName() {
        String name = getName(1980, 350, "F");
        System.out.println("The number 350 ranked female name in 1980 was: " + name);
        name = getName(1982, 450, "M");
        System.out.println("The number 450 ranked male name in 1982 was: " + name);
        //name = getName(2012, 6, "M");
        //System.out.println("The number 6 ranked male name in 2012 was: " + name);
    }
    
    public void testWhatIsNameInYear () {
        whatIsNameInYear("Susan", 1972, 2014, "F");
        whatIsNameInYear("Owen", 1974, 2014, "M");
    }
    
    public void testYearOfHighestRank () {
        //int year = yearOfHighestRank("Genevieve", "F");
        //System.out.println("Year with Highest Rank for Genevieve (F) was: " + year);
        int year = yearOfHighestRank("Mich", "M");
        System.out.println("Year with Highest Rank for Mich (M) was: " + year);
    }
    
    public void testGetAverageRank () {
        double avg = getAverageRank("Robert", "M");
        System.out.println("Average Rank for Robert (M) is: " + avg);
        //avg = getAverageRank("Jacob", "M");
        //System.out.println("Average Rank for Jacob (M) is: " + avg);
    }
    
    public void testGetTotalBirthsRankedHigher () {
        int totalBirths = getTotalBirthsRankedHigher(1990, "Drew", "M");
        System.out.println("Total Births: " + totalBirths);
    }
}
