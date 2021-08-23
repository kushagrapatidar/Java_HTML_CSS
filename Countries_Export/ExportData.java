import edu.duke.*;
import org.apache.commons.csv.*;
public class ExportData {
    public String countryInfo(CSVParser parser, String country){
        for(CSVRecord record: parser){
            if(record.get("Country").equals(country)){
                return record.get("Country")+": "+record.get("Exports")+": "+record.get("Value (dollars)");
            }
        }
        return "NOT FOUND";
    }
    
    public void listExportersYwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for(CSVRecord record: parser){
            String Exports=record.get("Exports");
            if(Exports.contains(exportItem1)&&Exports.contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int count=0;
        for(CSVRecord record: parser){
            String Exports=record.get("Exports");
            if(Exports.contains(exportItem)){
                count+=1;
            }
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser, int amountlength){
        for(CSVRecord record: parser){
            String amount=record.get("Value (dollars)");
            int diff=amountlength-amount.length();
            if(diff<0){
                System.out.println(record.get("Country")+": "+record.get("Value (dollars)"));
            }
        }
    }
    
    public void tester(){
        FileResource fr= new FileResource();
        CSVParser parser=fr.getCSVParser();
        //String CountryInfo=countryInfo(parser,"Nauru");
        //System.out.println(CountryInfo);
        
        //parser=fr.getCSVParser();
        //listExportersYwoProducts(parser,"cotton","flowers");
        
        //parser=fr.getCSVParser();
        String exportItem="cocoa";
        //int countryCount=numberOfExporters(parser,exportItem);
        //System.out.println(countryCount+" countries export "+exportItem);
        
        //parser=fr.getCSVParser();
        String amount= "$999,999,999,999";
        bigExporters(parser, amount.length());        
    }
}