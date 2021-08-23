import edu.duke.StorageResource;
import edu.duke.FileResource;
public class Part1 {
    public int findStopCodon(String dnaStr,int startIndex,String stopCodon){
        int currIndex=dnaStr.indexOf(stopCodon,startIndex+3);
        while(currIndex!=-1){
            int diff = currIndex- startIndex;
            if(diff%3==0){return currIndex;}
            else{
                currIndex=dnaStr.indexOf(stopCodon, currIndex+1);
            }
        }
        return -1; 
    }
    public String findGene(String dna, int where){
        int startIndex=dna.indexOf("ATG", where);
        if(startIndex==-1){return "";}
        int taaIndex=findStopCodon(dna,startIndex,"TAA");
        int tgaIndex=findStopCodon(dna,startIndex,"TGA");
        int tagIndex=findStopCodon(dna,startIndex,"TAG");
        int minIndex=0;
        if(minIndex==dna.length()){return "";}
        if(taaIndex==-1||tgaIndex!=-1&&tgaIndex<taaIndex){minIndex=tgaIndex;}
        else{minIndex=taaIndex;}
        if(minIndex==-1||tagIndex!=-1&&tagIndex<minIndex){minIndex=tagIndex;}
        if(minIndex==-1){return "";}
        return dna.substring(startIndex,minIndex+3);
    }
    public StorageResource getAllGenes(String dna){
        StorageResource geneList=new StorageResource();
        int startIndex=0;
        while(true){
            String Gene=findGene(dna,startIndex);
            if(Gene.isEmpty()){
                break;
            }
            System.out.println(Gene);
            geneList.add(Gene);
            startIndex=dna.indexOf(Gene,startIndex)+Gene.length();
        }
        return geneList;
    }
    public int countOccurence(String base,String segment){
        int count=0;
        int startIndex=0;
        while(true){
            startIndex=base.indexOf(segment,startIndex);
            if(startIndex==-1){break;}
            count=count+1;
            startIndex=startIndex+segment.length();
        }
        return count;
    }
    public double cgRatio(String gene){
        int countC=countOccurence(gene,"C");
        int countG=countOccurence(gene,"G");
        double cgratio=(float)(countC+countG)/gene.length();
        return cgratio;
    }
    public void processGenes(StorageResource sr){
        int genecount=0;
        int count=0;
        int cgCount=0;
        int longest=0;
        for(String s: sr.data()){
            if(s.length()>60){
                System.out.println("Gene\n\""+s.toLowerCase()+"\"\nis longer than 60 characters."); 
                genecount+=1;
            }
            if(cgRatio(s)>0.35){System.out.println("Gene \""+s+"\" has C-G-ratio higher than 0.35."); cgCount+=1;}
            if(longest<s.length()){longest=s.length();}
            count+=1;
        }
        System.out.println("The number of genes that are longet than 60 characters "+genecount);
        System.out.println("The number of genes that have C-G-ratio higher than 0.35 are "+cgCount);
        System.out.println("The length of the longest gene is "+longest+" characters");
        System.out.println(count);
    }
    public int countCTG(String dna){
        int CTGcount=countOccurence(dna,"CTG");
        return CTGcount;
    }
    public void testProcessGenes(){
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        StorageResource geneList=getAllGenes(dna.toUpperCase());
        processGenes(geneList);
        int CTGcount=countCTG(dna.toUpperCase());
        System.out.println(CTGcount);
    }
}
