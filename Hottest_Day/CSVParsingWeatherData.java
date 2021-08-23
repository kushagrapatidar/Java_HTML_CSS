import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
public class CSVParsingWeatherData{
    public CSVRecord getcoldestOfTwo(CSVRecord record,CSVRecord coldestSoFar){
        if(Double.parseDouble(record.get("TemperatureF"))==-9999){}
        else if(coldestSoFar==null||Double.parseDouble(coldestSoFar.get("TemperatureF"))>Double.parseDouble(record.get("TemperatureF"))){
            coldestSoFar=record;
        }
        return coldestSoFar;
    }
    
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestSoFar=null;
        for(CSVRecord record: parser){
            coldestSoFar=getcoldestOfTwo(record,coldestSoFar);
        }
        return coldestSoFar;
    }
    
    public String fileWithColdestTemperature(){
        CSVRecord coldestSoFar=null;
        CSVRecord temp=null;
        DirectoryResource dr=new DirectoryResource();
        File rf=null;
        for(File f : dr.selectedFiles()){
            FileResource fr=new FileResource(f);
            CSVParser parser=fr.getCSVParser();
            CSVRecord record = coldestHourInFile(parser);
            coldestSoFar=getcoldestOfTwo(record,coldestSoFar);
            if(temp==null||temp!=coldestSoFar){
                temp=coldestSoFar;
                rf=f;
            }
        }
        String file=rf.getAbsolutePath();
        return file;
    }
    
    public void testFileWithColdestTemperature(){
        String file=fileWithColdestTemperature();
        FileResource fr=new FileResource(file);
        int Index=file.indexOf("weather");
        file=file.substring(Index,file.length());
        System.out.println("Coldest day was in file "+file);
        
        CSVParser parser=fr.getCSVParser();
        CSVRecord coldest = coldestHourInFile(parser);
        System.out.println("Coldest Temperature on that day was "+coldest.get("TemperatureF"));
        
        parser=fr.getCSVParser();
        System.out.println("All the Temperatures on the coldest day were: ");
        for(CSVRecord record : parser){
            System.out.println(record.get("DateUTC")+": "+record.get("TemperatureF"));
        }
    }
    
    //HUMIDITY
    
    public CSVRecord getlowestOfTwo(CSVRecord record,CSVRecord lowestSoFar){
        if(record.get("Humidity").equals("N/A")){}
        else if(lowestSoFar==null||Integer.parseInt(lowestSoFar.get("Humidity"))>Integer.parseInt(record.get("Humidity"))){
            lowestSoFar=record;
        }
        return lowestSoFar;
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestSoFar=null;
        for(CSVRecord record: parser){
            lowestSoFar=getlowestOfTwo(record,lowestSoFar);
        }
        return lowestSoFar;
    }
    
    public CSVRecord lowestHumidityInManyFiles(){
        DirectoryResource dr=new DirectoryResource();
        CSVRecord lowestSoFar=null;
        for(File f : dr.selectedFiles()){
            FileResource fr=new FileResource(f);
            CSVParser parser=fr.getCSVParser();
            CSVRecord record = lowestHumidityInFile(parser);
            lowestSoFar=getlowestOfTwo(record,lowestSoFar);
        }
        return lowestSoFar;
    }
    
    public void testlowestHumidityInManyFiles(){
        CSVRecord lowest = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was "+lowest.get("Humidity")+" at "+lowest.get("DateUTC"));
    }
   
    //AVERAGE TEMPERATURE
    
    public double averageTemperatureInFile(CSVParser parser){
        int count=0;
        double sum=0;
        for(CSVRecord record: parser){
            if(Double.parseDouble(record.get("TemperatureF"))!=-9999){
                count+=1;
                sum+=Double.parseDouble(record.get("TemperatureF"));
            }
        }
        double avg=sum/count;
        return avg;
    }
    
    public void testAverageTemperatureInFile(){
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();
        double average = averageTemperatureInFile(parser);
        System.out.println("Average Temperature in file is "+average);
    }
    
    //AVERAGE TEMPERATURE
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        int count=0;
        double sum=0;
        for(CSVRecord record: parser){
            //if(record.get("Humidity").equals("N/A")||Double.parseDouble(record.get("TemperatureF"))==-9999)
            if(Integer.parseInt(record.get("Humidity"))>=value){
                count+=1;
                sum+=Double.parseDouble(record.get("TemperatureF"));
            }
        }
        
        double avg;
        if(sum==0.00&&count==0){avg=0.00;}
        else{avg=sum/count;}
        return avg;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();
        double average = averageTemperatureWithHighHumidityInFile(parser,80);
        if(average==0.00){System.out.println("No temperatures with that humidity");}
        else{
            System.out.println("Average Temp when high Humidity is "+average);
        }
    }
}
