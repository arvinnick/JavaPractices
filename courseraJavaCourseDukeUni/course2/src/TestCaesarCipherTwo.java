import edu.duke.FileResource;

public class TestCaesarCipherTwo {

    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final private static char[] alphabetArray = alphabet.toCharArray();
    private static char[] halfOfString(String message, int start){
        char[] inputArray = message.toCharArray();
        int oddIndex = start;
        char[] keyOneArray = new char[inputArray.length/2];
        for (int i = 0; i < keyOneArray.length; i++){
            keyOneArray[i] = inputArray[oddIndex];
            oddIndex = oddIndex + 2;
        }
        return keyOneArray;
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
    private static int[] countLetters(char[] inputArray){
        int[] res = new int[26];
        for (char ch : inputArray){
            for (char alph : alphabetArray){
                if (alph == Character.toUpperCase(ch)){
                    res[alphabet.indexOf(alph)]++;
                    break;
                }
            }
        }
        return res;
    }
    private static int maxIndex(int[] inputArray){
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        int c = 0;
        for (int i : inputArray){
            if (i >= max){
                max = i;
                maxIndex = c;
            }
            c++;
        }
        return maxIndex;
    }
    public static void simpleTests(){
        CesarCipherTwo cc = new CesarCipherTwo(17, 10);
        FileResource file = new FileResource();
        System.out.println(file.asString());
        System.out.println("''''''''");
        String enc = cc.encrypt(file.asString());
        System.out.println(enc);
        String dec = cc.decryptTwoKeys(enc);
        System.out.println("''''''''");
        System.out.println(dec);
        System.out.println("''''''''");
        String dec2 = breakCaesarCipher(enc);
        System.out.println(dec2);


    }

    public static String breakCaesarCipher(String input){
        char[] keyOneArray = halfOfString(input,0);
        char[] keyTwoArray = halfOfString(input,1);
        int keyOne = getKey(String.valueOf(keyOneArray));
        int keyTwo = getKey(String.valueOf(keyTwoArray));

        CesarCipherTwo cc = new CesarCipherTwo(keyOne,keyTwo);
        String firstMessage = cc.decryptTwoKeys(input);

//        int oddIndex = 0;
//        int evenIndex = 1;
//        char[] inputArray = input.toCharArray();
//            for (int i = 0; oddIndex < inputArray.length - 1; i++){
//            inputArray[oddIndex] = firstMessage[i];
//            inputArray[evenIndex] = secondMessage[i];
//            oddIndex = oddIndex + 2;
//            evenIndex = evenIndex + 2;
//        }
//
//        String res = String.valueOf(inputArray);
        return String.valueOf(firstMessage);
    }

    public static void main(String[] args) {
        simpleTests();
    }

}
