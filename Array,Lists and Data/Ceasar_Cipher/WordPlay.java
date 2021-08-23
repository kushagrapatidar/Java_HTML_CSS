import edu.duke.*;
public class WordPlay {
    public Boolean isVowel(char ch){
        char lowerCh=Character.toLowerCase(ch);
        if(lowerCh=='a'||lowerCh=='e'||lowerCh=='i'||lowerCh=='o'||lowerCh=='u'){return true;}
        return false;
    }
    
    public String replaceVowels(String phrase,char ch){
        StringBuilder str=new StringBuilder(phrase);
        for(int i=0;i<str.length();i++){
            char currChar=str.charAt(i);
            if(isVowel(currChar)){str.setCharAt(i,ch);}
        }
        phrase=str.toString();
        return phrase;
    }
    
    public String emphasize(String phrase,char ch){
        StringBuilder str=new StringBuilder(phrase);
        for(int i=0;i<str.length();i++){
            char currChar=str.charAt(i);
            if(Character.toLowerCase(currChar)==Character.toLowerCase(ch)){
                if((i+1)%2==0){str.setCharAt(i,'+');}
                else if((i+1)%2==1){str.setCharAt(i,'*');}
            }
        }
        phrase=str.toString();
        return phrase;
    }
    
    public void tester(){
        System.out.println(emphasize("dna ctgaaactga",'a'));
        System.out.println(emphasize("Mary Bella Abracadabra",'a'));
    }
}
