import edu.duke.StorageResource;
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
    public void processGenes(StorageResource sr) {
        StorageResource dnaList9 = longerThan(sr, 9);
        StorageResource dnaListRatio = cgRatio(sr, 0.35);
        
        System.out.println("DNA strands longer than 9 characters:");
        for (String dna: dnaList9.data()) {
            System.out.println(dna);
        }
        System.out.println("There is a total of " + dnaList9.size() + " DNA strands longer than 9 characters");
        System.out.println("################################################################################");
        System.out.println("DNA strands whose C-G-ratio is higher than 0.35 are:");
        for (String dna: dnaListRatio.data()) {
            System.out.println(dna);
        }
        System.out.println("There is a total of " + dnaListRatio.size() + " DNA strands whose C-G-ratio is higher than 0.35");
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
        processGenes(sr);
    }
    
}
