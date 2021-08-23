public class Part2 {
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
    public double cgRatio(String dna){
        int countC=countOccurence(dna,"C");
        int countG=countOccurence(dna,"G");
        double cgRatio=(float)((countC+countG)/dna.length());
        return cgRatio;
    }
    public int countCTG(String dna){
        int CTGcount=countOccurence(dna,"CTG");
        return CTGcount;
    }
    public void test(){
        double cgRatio=cgRatio("ATGCCATAG");
        System.out.println("C:G Ratio is "+cgRatio);
    }
}
