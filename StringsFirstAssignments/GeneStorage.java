import edu.duke.StorageResource;
public class GeneStorage {
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
            geneList.add(Gene);
            startIndex=dna.indexOf(Gene,startIndex)+Gene.length();
        }
        return geneList;
    }
    public void printAllGenes(StorageResource geneList){
        for(String gene:geneList.data()){System.out.println(gene);}
    }
    public void testOn(String dna){
        System.out.println("Testing printAllGenes on "+dna);
        StorageResource geneList=getAllGenes(dna);
        printAllGenes(geneList);
    }
    public void test(){
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        testOn("");
        testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
    }
}
