import edu.duke.*;
import java.io.*;
public class BatchInversion{
    public ImageResource makeInversion(ImageResource inImage){
        ImageResource outImage=new ImageResource(inImage.getWidth(),inImage.getHeight());
        for(Pixel pixel : outImage.pixels()){
            Pixel inPixel=inImage.getPixel(pixel.getX(),pixel.getY());
            int red=255-inPixel.getRed();
            int green=255-inPixel.getGreen();
            int blue=255-inPixel.getBlue();
            pixel.setRed(red);
            pixel.setGreen(green);
            pixel.setBlue(blue);
        }
        return outImage;
    }
    
    public void selectAndConvert(){
        DirectoryResource dr=new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource ir=new ImageResource(f);
            String fname=ir.getFileName();
            String newName="inverted-"+fname;
            ImageResource inverted=makeInversion(ir);
            inverted.setFileName(newName);
            inverted.draw();
            inverted.save();
        }
    }
}
