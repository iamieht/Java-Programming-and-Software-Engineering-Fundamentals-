
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    public String findSimpleGene(String dna) {
        //start codon is "ATG"
        // stop codon is "TAA"
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) //no ATG
        {
            return "";
        }
        int stopIndex = dna.indexOf("TAA");
        if (stopIndex == -1) //no TAA
        {
            return "";
        }
        if ((startIndex - stopIndex) % 3 == 0) {
            result = dna.substring(startIndex, stopIndex+3);
    }
        return result;
    }
    public void testSimpleGene() {
        String dna = "AATGCGATAATATGGT"; //Valid GENE
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "ACTAGGGTAATT"; //Invalid no ATG but TAA
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "ATCCTATGCTTCGGCTGCTCTATGGT"; //Invalid no TAA but ATG
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "ATATAT"; //Invalid no ATG and no TAA
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "ATGATAA"; //Invalid ATG and TAA present but  not multiple of 3
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
    }
}
