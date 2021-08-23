public class AllCodonsAnd {
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
    public String findGene(String dna){
        int startIndex=dna.indexOf("ATG");
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
    public void  testFindGeneSimple(){
        String dna="ATGCCCGGGAAATAACCC";
        String gene=findGene(dna);
        if(!gene.equals("ATGCCCGGGAAATAA")){System.out.println("error");}
        System.out.println("tests finished");
    }
}
