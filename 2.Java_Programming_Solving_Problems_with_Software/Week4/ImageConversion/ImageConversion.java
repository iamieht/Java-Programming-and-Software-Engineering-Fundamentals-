
/**
 * Write a description of ImageConversion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class ImageConversion {
    
    public ImageResource makeGray(ImageResource inImage) {
    
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for (Pixel pixel : outImage.pixels()) {
        
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) / 3;
            
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        return outImage;
    }
    
    public ImageResource makeInversion(ImageResource inImage) {
    
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel : outImage.pixels()) {
        
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int red = 255 - inPixel.getRed();
            int blue = 255 - inPixel.getBlue();
            int green = 255 - inPixel.getGreen();
            
            pixel.setRed(red);
            pixel.setGreen(green);
            pixel.setBlue(blue);
        }
        return outImage;
    }
    
    public void selectAndConvertGray() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeGray(inImage);
            String fname = inImage.getFileName();
            String newName = "gray-" + fname;
            gray.setFileName(newName);
            gray.save();
        }
    }
    
    public void selectAndConvertInversion() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeInversion(inImage);
            String fname = inImage.getFileName();
            String newName = "inverted-" + fname;
            gray.setFileName(newName);
            gray.save();
        }
    }

}
