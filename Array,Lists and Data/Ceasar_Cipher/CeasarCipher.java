import edu.duke.*;
//key=17
public class CeasarCipher {
    public String encrypt(String input, int key){
        StringBuilder encrypted=new StringBuilder(input);
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String sAlphabet=alphabet.toLowerCase();
        String shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
        String shiftedSAlphabet=sAlphabet.substring(key)+sAlphabet.substring(0,key);
        for(int i=0;i<encrypted.length();i++){
            char currChar = encrypted.charAt(i);
            if(sAlphabet.indexOf(currChar)!=-1){   
            int idx=sAlphabet.indexOf(currChar);
            if(idx!=-1){
                char newChar=shiftedSAlphabet.charAt(idx);
                encrypted.setCharAt(i,newChar);
            }
            }
            else{
                int idx=alphabet.indexOf(currChar);
                if(idx!=-1){
                       char newChar=shiftedAlphabet.charAt(idx);
                       encrypted.setCharAt(i,newChar);
                }
            }
        }
        return encrypted.toString();
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
        int tempIdx=0;
        StringBuilder encrypted1=new StringBuilder(encrypt(input,key1));
        StringBuilder encrypted2=new StringBuilder(encrypt(input,key2));;
        StringBuilder encrypted=new StringBuilder(input);
        
        for(int i=0;i<encrypted.length();i++){
            if(tempIdx%2==0||i==0){
                tempIdx+=1;
                char newChar=encrypted1.charAt(i);
                encrypted.setCharAt(i,newChar);
            }
            else{
                tempIdx+=1;
                char newChar=encrypted2.charAt(i);
                encrypted.setCharAt(i,newChar);
            }
        }
        return encrypted.toString();
    }
    
    public void testCeasar(){
        int key1=23;
        int key2=17;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        String encrypted = encryptTwoKeys("First Legion", 23, 17);
        System.out.println("keys are " + key1+" & "+ key2 + "\n" + encrypted);
    }
}
