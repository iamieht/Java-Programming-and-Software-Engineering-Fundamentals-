
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {

    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        //start codon is "ATG"
        // stop codon is "TAA"
        String result = "";
        Boolean changeCase = false;
        
        if (dna == dna.toUpperCase()) {
            changeCase = false;
        } else {
            changeCase = true;
        };
        
        dna = dna.toUpperCase();
        startCodon = startCodon.toUpperCase();
        stopCodon = stopCodon.toUpperCase();
        
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1) //no ATG
        {
            return "";
        }
        int stopIndex = dna.indexOf(stopCodon);
        if (stopIndex == -1) //no TAA
        {
            return "";
        }
        if ((startIndex - stopIndex) % 3 == 0) {
            result = dna.substring(startIndex, stopIndex+3);
    }
        if (changeCase) {
            return result.toLowerCase();
        } else {
            return result;
        }
    }
    public void testSimpleGene() {
        String dna = "AATGCGATAATATGGT"; //Valid GENE
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "gatgctataat"; //Valid GENE
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "ACTAGGGTAATT"; //Invalid no ATG but TAA
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "ATCCTATGCTTCGGCTGCTCTATGGT"; //Invalid no TAA but ATG
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "ATATAT"; //Invalid no ATG and no TAA
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        dna = "ATGATAA"; //Invalid ATG and TAA present but  not multiple of 3
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
    }
}
