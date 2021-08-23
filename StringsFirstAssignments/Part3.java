public class Part3 {
    
    public boolean twoOccurrences(String stringa, String stringb){
        int count=0;
        int Index=-1;
        int b=0;
        int temp=-1;
        while(b==0){
            int newIndex = stringb.indexOf(stringa,Index);
            Index=newIndex+stringa.length();
            if ((newIndex == -1||newIndex==temp)&&count<2) {
                return false;
            }
            else if(count>=2){
                break;
            }
            else{
                temp=Index;
                count+=1;
            }
            
        }
        return true;
    }
    
    public String lastPart(String stringa, String stringb){   
        int Index=-1;
        Index = stringb.indexOf(stringa);
        if (Index==-1) {
            return stringb;
        }
        else {
            Index+=stringa.length();
            return stringb.substring(Index);
        }
    }
    
    public void testing(){
        String stringa="by";
        String stringb="A story by Ab Long";
        System.out.println("stringa= "+stringa+" and stringb= "+stringb);
        System.out.println(twoOccurrences(stringa,stringb));
        System.out.println("\n");
        
        stringa="a";
        stringb="banana";
        System.out.println("stringa= "+stringa+" and stringb= "+stringb);
        System.out.println(twoOccurrences(stringa,stringb));
        System.out.println("\n");
        
        stringa="atg";
        stringb="ctgtatgta";
        System.out.println("stringa= "+stringa+" and stringb= "+stringb);
        System.out.println(twoOccurrences(stringa,stringb));
        
        String sep="";
        for(int i=0;i<40;i++){sep+="*";}
        System.out.println(sep);
        System.out.println("\n");
        
        stringa="zoo";
        stringb="forest";
        System.out.println("stringa= "+stringa+" and stringb= "+stringb);
        System.out.println(lastPart(stringa,stringb));
        System.out.println("\n");
        
        stringa="an";
        stringb="banana";
        System.out.println("stringa= "+stringa+" and stringb= "+stringb);
        System.out.println(lastPart(stringa,stringb));
    }
           
}
