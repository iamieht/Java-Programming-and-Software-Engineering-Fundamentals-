import edu.duke.StorageResource;
import edu.duke.FileResource;
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
    
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0) {
                return currIndex;
            }
            else {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
            
        }
        return dna.length();
    }
    
    public String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        int temp = Math.min(taaIndex,tagIndex);
        int minIndex = Math.min(temp,tgaIndex);
        if (minIndex == dna.length()) {
            return "";
        }
        return dna.substring(startIndex,minIndex + 3);
    }
    
    public StorageResource getAllGenes(String dna) {
        StorageResource geneList = new StorageResource();
        int startIndex = 0;
        
        while (true) {
            String currentGene = findGene(dna, startIndex);
            
            if (currentGene.isEmpty()) {
                break;
            }
            geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return geneList;
    }
    
    public void processGenes(StorageResource sr, int length, double ratio) {
        StorageResource dnaList9 = longerThan(sr, length);
        StorageResource dnaListRatio = cgRatio(sr, ratio);
        
        System.out.println("DNA strands longer than " + length + " characters:");
        for (String dna: dnaList9.data()) {
            System.out.println(dna);
        }
        System.out.println("There is a total of " + dnaList9.size() + " DNA strands longer than " + length + " characters");
        System.out.println("################################################################################");
        System.out.println("DNA strands whose C-G-ratio is higher than 0.35 are:");
        for (String dna: dnaListRatio.data()) {
            System.out.println(dna);
        }
        System.out.println("There is a total of " + dnaListRatio.size() + " DNA strands whose C-G-ratio is higher than " + ratio);
    }
    
    public StorageResource longerThan(StorageResource sr, int length){
        StorageResource dnaList = new StorageResource();
        for (String dna: sr.data()) {
            if (dna.length() > length) {
                dnaList.add(dna);
            }
        }
        return dnaList;
    }
    
    public StorageResource cgRatio(StorageResource sr, double ratio) {
        StorageResource dnaListRatio = new StorageResource();
        char c = 'C';
        char g = 'G';
        for (String dna: sr.data()) {
            double dnaLength = dna.length();
            double total = 0;
            for (char ch: dna.toCharArray()) {
                if (ch == c || ch == g) {
                    total++;
                }
            }
            if ((total / dnaLength) > ratio) {
                dnaListRatio.add(dna);
        }
      }
      return dnaListRatio;
    }
    
    public void testProcessGenes() {
        StorageResource sr = new StorageResource();
        sr.add("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        sr.add("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
        sr.add("ATGCCCGGGAAATAACCC");
        sr.add("CGATGGTTGATAAGCCTAAGCTATAA");
        sr.add("ATGCCATAG");
        //processGenes(sr, 9, 0.35);
        System.out.println(sr.data());
    }
    
    public void testProcessGenesFile() {
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        dna = dna.toUpperCase();
        //System.out.println(dna);
        StorageResource allGenes = getAllGenes(dna);
        System.out.println(allGenes.data());
        //processGenes(allGenes, 60, 0.35);
        
    }
}
