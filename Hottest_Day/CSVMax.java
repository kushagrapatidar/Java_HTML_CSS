import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
public class CSVMax{
    public CSVRecord gethighestOfTwo(CSVRecord record,CSVRecord highestSoFar){
        if(highestSoFar==null||Double.parseDouble(highestSoFar.get("TemperatureF"))<Double.parseDouble(record.get("TemperatureF"))){
            highestSoFar=record;
        }
        return highestSoFar;
    }
    
    public CSVRecord hottestHourInFile(CSVParser parser){
        CSVRecord highestSoFar=null;
        for(CSVRecord record: parser){
            highestSoFar=gethighestOfTwo(record,highestSoFar);
        }
        return highestSoFar;
    }
    
    public CSVRecord hottestInManyDays(){
        DirectoryResource dr=new DirectoryResource();
        CSVRecord highestSoFar=null;
        for(File f : dr.selectedFiles()){
            FileResource fr=new FileResource(f);
            CSVParser parser=fr.getCSVParser();
            CSVRecord record = hottestHourInFile(parser);
            highestSoFar=gethighestOfTwo(record,highestSoFar);
        }
        return highestSoFar;
    }
    
    public void test(){
        CSVRecord highest=hottestInManyDays();
        System.out.println("hottest temperature was "+ highest.get("TemperatureF")+" at "+highest.get("DateUTC"));
    }
}
