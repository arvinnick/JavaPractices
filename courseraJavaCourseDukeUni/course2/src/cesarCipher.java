import edu.duke.FileResource;

import java.nio.file.LinkPermission;


public class cesarCipher {
    
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String stringShifter(int key){
        String ret;
        //write the alphabet
        //take the tail (substrig by key)
        String tail = alphabet.substring(key);
        //take the head (substring begin with 0 and end with key)
        String head = alphabet.substring(0,key);
        //add the tail to the head
        ret = tail + head;
        return ret;
    }
    static String encrypt(String input, int key){
        //initialize the return
        String ret = "";
        //build the shiftedAlphabet
        String shiftedAlphabet = stringShifter(key);
        //for charachter in input:
        for (int i = 0; i < input.length(); i++) {
            //turn the charachter into upper case
            char ch = input.charAt(i);
            boolean lowerCase = Character.isLowerCase(ch);
            ch = Character.toUpperCase(ch);
            //find the index of the charachter in
            int index = alphabet.indexOf(ch);
            char shiftCh = ' ';
            try {
                //find the charachter at the index in shifter
                shiftCh = shiftedAlphabet.charAt(index);
            } catch (StringIndexOutOfBoundsException e){
                shiftCh = ch;
            }
            finally {
                if(lowerCase){
                    shiftCh = Character.toLowerCase(shiftCh);
                }
                //add the charachter to the return
                ret = ret + shiftCh;
            }
        }
        return ret;
    }
    static void testEncrypt(){
        System.out.println(encrypt("FIrST LEgION ATTACK EAST FLANK!",
                23).equals("CFoPQ IBdFLK XQQXZH BXPQ CIXKH!"));
    }

    static void testCaesar() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, 12);
        System.out.println("key is " + 12 + "\n" + encrypted);
    }
    static void testStringShifter(){
        if(stringShifter(12).equals("MNOPQRSTUVWXYZABCDEFGHIJKL")){
            System.out.println("test 1 passed");
        }
        if(stringShifter(13).equals("NOPQRSTUVWXYZABCDEFGHIJKLM")) {
            System.out.println("test 2 passed");
        }
            if (stringShifter(20).equals("UVWXYZABCDEFGHIJKLMNOPQRST")) {
                System.out.println("test 2 passed");
            }
        }

    public static void main(String[] arg){
        testEncrypt();
    }


    
}
