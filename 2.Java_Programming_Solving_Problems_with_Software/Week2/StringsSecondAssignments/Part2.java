
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
    public int howMany(String stringa, String stringb) {
        if (stringa.isEmpty() || stringb.isEmpty()) {
            return 0;
        }
        int startIndex = stringb.indexOf(stringa);
        int count = 0;
        
        while (startIndex != -1) {
            count++;
            startIndex = stringb.indexOf(stringa, (startIndex + stringa.length()));
        }
        return count;
    }
    
    public void testHowMany() {
        String stringa = "GAA";
        String stringb = "ATGAACGAATTGAATC";
        System.out.println("String " + stringa + " in " + stringb + " repeats " + howMany(stringa, stringb) + " times");
        
        stringa = "AA";
        stringb = "ATAAAA";
        System.out.println("String " + stringa + " in " + stringb + " repeats " + howMany(stringa, stringb) + " times");
        
        stringa = "BB";
        stringb = "Empty";
        System.out.println("String " + stringa + " in " + stringb + " repeats " + howMany(stringa, stringb) + " times");
        
        stringa = "aa";
        stringb = "ATAAAA";
        System.out.println("String " + stringa + " in " + stringb + " repeats " + howMany(stringa, stringb) + " times");
        
        stringa = "a";
        stringb = "";
        System.out.println("String " + stringa + " in " + stringb + " repeats " + howMany(stringa, stringb) + " times");
        
        stringa = "";
        stringb = "a";
        System.out.println("String " + stringa + " in " + stringb + " repeats " + howMany(stringa, stringb) + " times");
    }


}
