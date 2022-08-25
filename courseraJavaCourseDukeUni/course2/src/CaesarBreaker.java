import edu.duke.FileResource;

import java.util.Arrays;
import java.util.Random;

public class CaesarBreaker extends cesarCipher {


    static char[] alphabetArray = alphabet.toCharArray();
    static int[] countLetters(char[] inputArray){
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
    static int maxIndex(int[] inputArray){
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
    static String decryptTwoKeys(String input){
        char[] keyOneArray = halfOfString(input,0);
        char[] keyTwoArray = halfOfString(input,1);

//        int keyOne = getKey(String.valueOf(keyOneArray));
//        int keyTwo = getKey(String.valueOf(keyTwoArray));
        int keyOne = 20;
        int keyTwo = 2;

        char[] firstMessage = encrypt(String.valueOf(keyOneArray),keyOne).toCharArray();
        char[] secondMessage = encrypt(String.valueOf(keyTwoArray),keyTwo).toCharArray();

        int oddIndex = 0;
        int evenIndex = 1;
        char[] inputArray = input.toCharArray();
        for (int i = 0; oddIndex < inputArray.length - 1; i++){
            inputArray[oddIndex] = firstMessage[i];
            inputArray[evenIndex] = secondMessage[i];
            oddIndex = oddIndex + 2;
            evenIndex = evenIndex + 2;
        }

        String res = String.valueOf(inputArray);
        return res;
    }

    static int getKey(String s){
        char[] inputArray = s.toCharArray();
        int[] firstCountedLetters = countLetters(inputArray);
        int firstMax = maxIndex(firstCountedLetters);

        int dkey = firstMax - 4;

        if (dkey < 4){
            dkey = 26 - (4 - firstMax);
        }

        int key = 26 - dkey;
        return key;
    }
    static char[] halfOfString(String message, int start){
        char[] inputArray = message.toCharArray();
        int oddIndex = start;
        char[] keyOneArray = new char[inputArray.length/2];
        for (int i = 0; i < keyOneArray.length; i++){
            keyOneArray[i] = inputArray[oddIndex];
            oddIndex = oddIndex + 2;
        }
    return keyOneArray;
    }

    static void testCountLetters(){
        String testInput = "MAMMAD UMAD KHUNEYE MAMANINA";
        char[] inputArray = testInput.toCharArray();
        int[] counts = countLetters(inputArray);
        int c = 0;
        for (char alph : alphabetArray){
            System.out.println(alph + " : " + counts[c]);
            c++;
        }
    }
    static void testMaxIndex(){
        Random rand = new Random();
        int[] input = new int[14];
        for (int i = 0; i < 14; i++){
            input[i] = rand.nextInt(15);
        }
        System.out.println(Arrays.toString(input));
        System.out.println(maxIndex(input));
    }
    static void testDecrypt(){
//        FileResource file = new FileResource();
        String encrypted = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
        System.out.println(decryptTwoKeys(encrypted));
        String decrypted = "Just a test string with lots of eeeeeeeeeeeeeeeees";

    }
    public static void main(String args[]){
        testDecrypt();
    }
}
