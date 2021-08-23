import edu.duke.*;
import java.io.*;
public class GrayScaleConverter {
    public ImageResource makeGray(ImageResource inImage){
        ImageResource outImage=new ImageResource(inImage.getWidth(),inImage.getHeight());
        for(Pixel pixel : outImage.pixels()){
            Pixel inPixel=inImage.getPixel(pixel.getX(),pixel.getY());
            int average=(inPixel.getRed()+inPixel.getGreen()+inPixel.getBlue())/3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        return outImage;
    }
    
    public void selectAndConvert(){
        DirectoryResource dr=new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource ir=new ImageResource(f);
            ImageResource gray=makeGray(ir);
            String fname=ir.getFileName();
            String newName="gray-"+fname;
            gray.setFileName(newName);
            gray.draw();
            gray.save();
        }
    }
}
