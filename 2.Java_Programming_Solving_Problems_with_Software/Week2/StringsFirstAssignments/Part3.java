
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
    public Boolean twoOccurrences(String stringa, String stringb) {
    
        int startIndex = stringb.indexOf(stringa);
        int stopIndex = stringb.indexOf(stringa, startIndex + stringa.length());
        Boolean result;
        if (startIndex == -1 || stopIndex == -1) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }
    public String lastPart(String stringa, String stringb) {
        
        int startIndex = stringb.indexOf(stringa);
        String result = "";
        
        if (startIndex == -1) {
            result = stringb;
        } else {
            result = stringb.substring(startIndex + stringa.length());
        }
        return result;
    }
    
    public void testing() {
    
        String stringa = "by";
        System.out.println("Stringa is " + stringa);
        String stringb = "A story by Abby Long";
        System.out.println("Stringb is " + stringb);
        Boolean isStringaInStringbTwice = twoOccurrences(stringa, stringb);
        System.out.println("isStringaInStringbTwice " + isStringaInStringbTwice);
        
        stringa = "a";
        System.out.println("Stringa is " + stringa);
        stringb = "banana";
        System.out.println("Stringb is " + stringb);
        isStringaInStringbTwice = twoOccurrences(stringa, stringb);
        System.out.println("isStringaInStringbTwice " + isStringaInStringbTwice);
        
        stringa = "atg";
        System.out.println("Stringa is " + stringa);
        stringb = "ctgtatgta";
        System.out.println("Stringb is " + stringb);
        isStringaInStringbTwice = twoOccurrences(stringa, stringb);
        System.out.println("isStringaInStringbTwice " + isStringaInStringbTwice);
        
        stringa = "an";
        stringb = "banana";
        String lastPart = lastPart(stringa, stringb);
        System.out.println("The part of the string after " + stringa + " in " + stringb + " is " + lastPart);
        
        stringa = "zoo";
        stringb = "forest";
        lastPart = lastPart(stringa, stringb);
        System.out.println("The part of the string after " + stringa + " in " + stringb + " is " + lastPart);
    }

}
