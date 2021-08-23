import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
public class BabyBirths {
    public void printNames(){
        FileResource fr = new FileResource();
        for(CSVRecord rec : fr.getCSVParser(false)){
            int numBorn=Integer.parseInt(rec.get(2));
            if(numBorn<=100){System.out.println("Name "+rec.get(0)+" Gender "+rec.get(1)+" Num Born "+rec.get(2));}
        }
    }
    
    public void totalBirths(FileResource fr){
        int totalBirths=0;
        int total=0;
        int numGirls=0;
        int totalGirls=0;
        int numBoys=0;
        int totalBoys=0;
        for(CSVRecord rec : fr.getCSVParser(false)){
            int numBorn=Integer.parseInt(rec.get(2));
            totalBirths+=numBorn;
            total+=1;
            if(rec.get(1).equals("F")){numGirls+=numBorn; totalGirls+=1;}
            if(rec.get(1).equals("M")){numBoys+=numBorn; totalBoys+=1;}
        }
        
        System.out.println("Total Names "+total);
        System.out.println("Total Girl Names "+totalGirls);
        System.out.println("Total Boy Names "+totalBoys);        
        System.out.println("Total Births "+totalBirths);
        System.out.println("Total Girls "+numGirls);
        System.out.println("Total Boys "+numBoys);
    }
    
    public int getRank(int year, String name, String gender){
        String file="data/yob"+year+".csv";
        FileResource fr=new FileResource(file);
        int rank=0;
        for(CSVRecord rec: fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                rank+=1;
                if(rec.get(0).equals(name)){return rank;}
            }
        }
        return -1;
    }
    
    public String getName(int year,int rank,String gender){
        String file="data/yob"+year+".csv";
        FileResource fr=new FileResource(file);
        int count=0;
        for(CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                count+=1;
                if(count==rank){return rec.get(0);}
            }
        }
        return "NO NAME";
    }
    
    public void whatIsNameInYear(int year, int newYear, String name, String gender){
        int rank=getRank(year,name,gender);
        String newName=getName(newYear,rank,gender);
        if(newName.equals("NO NAME")){System.out.println(name+" born in "+year+" would have "+newName+" if she was born in "+newYear+"."); }
        else{System.out.println(name+" born in "+year+" would be "+newName+" if she was born in "+newYear+"."); }
    }
    
    public int yearOfHighestRank(String name, String gender){
        int highestRank=0;
        int year=0;
        DirectoryResource dr=new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr=new FileResource(f);
            String file=f.getAbsolutePath();
            String str=file.substring(file.indexOf("yob")+3,file.indexOf(".csv"));
            int currYear=Integer.parseInt(str);
            for(CSVRecord rec : fr.getCSVParser()){
                if(highestRank==0||highestRank>getRank(currYear,name,gender)){
                    highestRank=getRank(currYear,name,gender);
                    year=currYear;
                }
            }
        }
        if(year==0){return -1;}
        else{return year;}
    }
    
    public double getAverageRank(String name, String gender){
        double averageRank;
        int count=0;
        int totalRank=0;
        DirectoryResource dr=new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr=new FileResource(f);
            String file=f.getAbsolutePath();
            String str=file.substring(file.indexOf("yob")+3,file.indexOf(".csv"));
            int currYear=Integer.parseInt(str);
            for(CSVRecord rec : fr.getCSVParser()){
                if(name.equals(rec.get(0))){
                    count+=1;
                    totalRank+=getRank(currYear,name,gender);
                }
            }
        }
        averageRank=(double)totalRank/count;
        if(totalRank==0){return -1;}
        else{return averageRank;}
    }
    
    public int getTotalBirthsRankedHigher(int year,String name,String gender){
        int totalBirthsHigher=0;
        int rank=getRank(year,name,gender);
        String file="data/yob"+year+".csv";
        FileResource fr=new FileResource(file);
        int count=0;
        for(CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                count+=1;
                if(count<rank){totalBirthsHigher+=Integer.parseInt(rec.get(2));}
            }
        }
        return totalBirthsHigher;
    }
    
    public void test(){
        double avg=getAverageRank("Susan","F");
        System.out.println(avg);
    }
}
