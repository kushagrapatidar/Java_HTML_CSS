/**
 * Write a description of FindGeneSimpleAndTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    public String findGeneSimple(String dna){
        String result="";
            int startIndex = dna.indexOf("ATG");
            
            if(startIndex == -1){return "";}
            int stopIndex = dna.indexOf("TAA", startIndex+3);
            if(stopIndex == -1){return "";}
            result = dna.substring(startIndex, stopIndex+3);
            if(result.length()%3==0){
                return result;
            }
            else{
                return "";
            }
               
    }
    
    public void testFindGeneSimple(){
        String dna = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("DNA strand is "+dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is "+gene);
        
        //dna = "AATGCTAGGGTAATATGGT";
        dna="CGATGGTTTG";
        System.out.println("DNA strand is "+dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is "+gene);
        
        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is "+dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is "+gene);
        
        //dna = "ATGTAA";
        dna = "TTATAA";
        System.out.println("DNA strand is "+dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is "+gene);
    }
}
