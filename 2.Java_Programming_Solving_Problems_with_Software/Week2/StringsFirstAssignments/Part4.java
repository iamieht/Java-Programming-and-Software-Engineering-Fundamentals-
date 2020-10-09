import edu.duke.*;
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    
    public String printYoutubeURLs(String url) {
        URLResource ur = new URLResource(url);
        String word2find = "youtube.com";
        String quote = "\"";
        String wordTemp = "";
        int startIndex = 0;
        String result = "";
        
        
        for (String word : ur.words()) {
            wordTemp = word.toLowerCase();
            startIndex = wordTemp.indexOf(word2find);
            if (startIndex != -1) {
                result = word.substring(word.indexOf(quote), word.indexOf(quote, startIndex+11)+1);
                //System.out.println("Original Word " + word);
                //System.out.println("Modified Word " + wordTemp);
                System.out.println("URL " + result);
            }
            
        }
        return "";
    }
    
    public void testPrintYoutubeURLs() {
        String url = "https://www.dukelearntoprogram.com//course2/data/manylinks.html";
        printYoutubeURLs(url);
    }
}
