public class AllCodons {
    public int findStopCodon(String dnaStr,int startIndex,String stopCodon){
        int currIndex=dnaStr.indexOf(stopCodon,startIndex+3);
        while(currIndex!=-1){
            int diff = currIndex- startIndex;
            if(diff%3==0){return currIndex;}
            else{
                currIndex=dnaStr.indexOf(stopCodon, currIndex+1);
            }
        }
        return dnaStr.length(); 
    }
    public String findGene(String dna){
        int startIndex=dna.indexOf("ATG");
        if(startIndex==-1){return "";}
        int taaIndex=findStopCodon(dna,startIndex,"TAA");
        int tgaIndex=findStopCodon(dna,startIndex,"TGA");
        int tagIndex=findStopCodon(dna,startIndex,"TAG");
        int minIndex=Math.min(taaIndex,Math.min(tagIndex,tgaIndex));
        if(minIndex==dna.length()){return "";}
        return dna.substring(startIndex,minIndex+3);
    }
    public void  testFindGeneSimple(){
        String dna="AATGCGTAATTAATCG";
        System.out.println("DNA strand is "+dna);
        String gene=findGene(dna);
        System.out.println("Gene is "+gene);
        
        dna="CGATGGTTGACTAGGCCTAAGCTATAA";
        System.out.println("DNA strand is "+dna);
        gene=findGene(dna);
        System.out.println("Gene is "+gene);
        
        dna="CGATGGTTGATAAGCCTAAGCTAAA";
        System.out.println("DNA strand is "+dna);
        gene=findGene(dna);
        System.out.println("Gene is "+gene);
    }
}
