import edu.duke.FileResource;

import java.util.Arrays;
import java.util.Random;



public class TestCaesarCipher {
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static char[] alphabetArray = alphabet.toCharArray();
    private static int[] countLetters(char[] inputArray){
        int[] res = new int[26];
        for (char ch : inputArray){
            int resPosition = 0;
            for (char alph : alphabetArray){
                if (alph == Character.toUpperCase(ch)){
                    res[resPosition]++;
                }
                resPosition++;
            }
        }
        return res;
    }
    private static int maxIndex(int[] inputArray){
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        int c = 0;
        for (int i : inputArray){
            if (i > max){
                max = i;
                maxIndex = c;
            }
            c++;
        }
        return maxIndex;
    }
    private static int getKey(String s){
        int[] freqs = countLetters(s.toCharArray());
        int macDex = maxIndex(freqs);
        int dkey = macDex - 4;
        if (macDex < 4) {
            dkey = 26 - (4 - macDex);
        }
        return dkey;
    }
    public static void simpleTests(){
        FileResource file = new FileResource();
        CesarCipher cc = new CesarCipher(18);
        String encrypted = cc.encrypt(file.asString());
        System.out.println(encrypted);
        System.out.println(cc.decrypt(encrypted));
        System.out.println(breakCaesarCipher(encrypted));
    }
    private static String breakCaesarCipher(String input){
        int key = getKey(input);
        CesarCipher cc  = new CesarCipher(key);
        return cc.decrypt(input);
    }

//    private void testCountLetters(){
//        String testInput = "MAMMAD UMAD KHUNEYE MAMANINA";
//        char[] inputArray = testInput.toCharArray();
//        int[] counts = countLetters(inputArray);
//        int c = 0;
//        for (char alph : alphabetArray){
//            System.out.println(alph + " : " + counts[c]);
//            c++;
//        }
//    }
//    static void testMaxIndex(){
//        Random rand = new Random();
//        int[] input = new int[14];
//        for (int i = 0; i < 14; i++){
//            input[i] = rand.nextInt(15);
//        }
//        System.out.println(Arrays.toString(input));
//        System.out.println(maxIndex(input));
//    }
//    static void testDecrypt(){
////        FileResource file = new FileResource();
//        String encrypted = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
//        System.out.println(decryptTwoKeys(encrypted));
//        String decrypted = "Just a test string with lots of eeeeeeeeeeeeeeeees";
//
//    }
//    private void testEncrypt(){
//        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",
//                8));//.equals("CFoPQ IBdFLK XQQXZH BXPQ CIXKH!"));
//    }
//    private void testCaesar() {
//        FileResource fr = new FileResource();
//        String message = fr.asString();
//        String encrypted = encrypt(message, 12);
//        System.out.println("key is " + 12 + "\n" + encrypted);
//    }
//    private void testStringShifter(){
//        if(stringShifter(12).equals("MNOPQRSTUVWXYZABCDEFGHIJKL")){
//            System.out.println("test 1 passed");
//        }
//        if(stringShifter(13).equals("NOPQRSTUVWXYZABCDEFGHIJKLM")) {
//            System.out.println("test 2 passed");
//        }
//        if (stringShifter(20).equals("UVWXYZABCDEFGHIJKLMNOPQRST")) {
//            System.out.println("test 2 passed");
//        }
//    }
    public static void main(String args[]){
        simpleTests();
    }
}
