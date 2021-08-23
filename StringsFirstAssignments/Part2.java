/**
 * Write a description of FindGeneSimpleAndTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
    public String findGeneSimple(String dna, String startCodon, String stopCodon){
        String result="";
            int startIndex = dna.indexOf(startCodon);
            if(startIndex == -1){return "";}
            int stopIndex = dna.indexOf(stopCodon, startIndex+3);
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
        String dna = "ATGGGTTAAGTC";
        System.out.println("DNA strand is "+dna);
        String gene = findGeneSimple(dna,"ATG","TAA");
        System.out.println("Gene is "+gene);
        
        dna="gatgctataat";
        System.out.println("DNA strand is "+dna);
        gene = findGeneSimple(dna.toUpperCase(),"ATG","TAA");
        System.out.println("Gene is "+gene.toLowerCase());
        
    }
}
