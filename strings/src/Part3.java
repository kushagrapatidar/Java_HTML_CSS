public class Part3 {
    
    public String twoOccurrences(String stringa, String stringb){
        int count=0;
        int Index=0;
        int b=0;
        while(b==0){
            if(count>=2){
                b=1;
            }
            else{
                int newIndex = stringb.indexOf(stringa,Index);            
                count=count+1;
                Index=newIndex;
            }
        }
        if(b==1){
            return "true";
        }
        else{
            return "false";
        }
    }
    
    public void testing(){
        String stringa="by";
        String stringb="A story  Ab Long";
        String result = twoOccurrences(stringa,stringb);
        System.out.println(result);
        
        stringa="a";
        stringb="banana";
        result = twoOccurrences(stringa,stringb);
        System.out.println(result);
        
        stringa="atg";
        stringb="ctgtatgta";
        result = twoOccurrences(stringa,stringb);
        System.out.println(result);
    }
           
}
