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
        
        for (String word : ur.words()) {
            System.out.println(word);
        }
        return "";
    }
    
    public void testPrintYoutubeURLs() {
        String url = "https://www.dukelearntoprogram.com//course2/data/manylinks.html";
        printYoutubeURLs(url);
    }
}
