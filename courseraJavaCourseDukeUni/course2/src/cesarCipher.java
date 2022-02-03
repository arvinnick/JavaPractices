import edu.duke.FileResource;

import java.util.Locale;

public class cesarCipher {

    static String encrypt(String input, int key){

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String tail = alphabet.substring(key);
        StringBuilder shiftedtedAlphabet = new StringBuilder(tail+alphabet);
        String shiftedtedAlphabetString = shiftedtedAlphabet.toString();
        shiftedtedAlphabetString = shiftedtedAlphabetString.substring(0,alphabet.length());
        StringBuilder inputBuilder = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            //check if the charachter is up. case or lo. case
            boolean up = Character.isUpperCase(ch);
            if (up){
                ch = Character.toLowerCase(ch);
            }
            if (alphabet.indexOf(ch) != -1) {
                //find the index of the char in alphabet
                int indexInAlphabet = alphabet.indexOf(ch);
                //find the char in the shifted alphabet for the same index
                char charAtShiftedAlphabet = shiftedtedAlphabetString.charAt(indexInAlphabet);
                //replace the char in input with the char of the shifted
                if (up){
                    charAtShiftedAlphabet = Character.toUpperCase(charAtShiftedAlphabet);
                }
                inputBuilder.setCharAt(i, charAtShiftedAlphabet);
            }
            else{
                inputBuilder.setCharAt(i, ch);
            }
        }
        return inputBuilder.toString();
    }
    static void testEncrypt(){
        System.out.println(encrypt("FIrST LEgION ATTACK EAST FLANK!",
                23).equals("CFoPQ IBdFLK XQQXZH BXPQ CIXKH!"));
    }

    static void testCaesar(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, 12);
        System.out.println("key is " + 12 + "\n" + encrypted);
    }

    static String encryptTwoKeys(String input, int key1, int key2){

        return "";
    }

    public static void main(String[] arg){
        testCaesar();
    }


    
}
