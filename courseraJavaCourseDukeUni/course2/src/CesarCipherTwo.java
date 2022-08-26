public class CesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private char[] alphabetArray;
    private int key1;
    private int key2;


    private String stringShifter(int key){
        String ret;
        //write the alphabet
        //take the tail (substrig by key)
        String head = "";
        String tail = "";
        if (key < 0){
            key = -1 * key;
            tail = alphabet.substring(alphabet.length() - key);
            head = alphabet.substring(0,alphabet.length()-key);
        } else {
            tail = alphabet.substring(key);
            //take the head (substring begin with 0 and end with key)
            head = alphabet.substring(0,key);
            //add the tail to the head
        }
        ret = tail + head;
        return ret;
    }

    public CesarCipherTwo(int key1, int key2){
        this.key1 = key1;
        this.key2 = key2;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.shiftedAlphabet1 = stringShifter(key1);
        this.shiftedAlphabet2 = stringShifter(key2);
        alphabetArray = alphabet.toCharArray();
    }
    private int[] countLetters(char[] inputArray){
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
    private int maxIndex(int[] inputArray){
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
    private int getKey(String s){
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
    public String encrypt(String input){
        //initialize the return
        char[] ret = input.toCharArray();
        char[] inputArray = input.toCharArray();
        //array of the shifted alphabets
        char[] shiftedAlphabet1Array = this.shiftedAlphabet1.toCharArray();
        char[] shiftedAlphabet2Array = this.shiftedAlphabet2.toCharArray();
        //build a check (if zero, take the letter from sh1 else from sh2)
        int check = 0;
        //for ch in input array
        int cInput = 0;
        for (char ch : inputArray) {
            //counter = 0
            int c = 0;
            //keep track of the case of the character and then capitalize it
            boolean capital = Character.isUpperCase(ch);
            ch = Character.toUpperCase(ch);
            //find the input letter number in alphabet
            for (char letter : alphabetArray) {
                if (ch == letter) {
                    break;
                }
                c++;
            }
            char retChar;
            //if check is zero:
            if (check == 0) {
                //ret[counter] = sh1[counter]
                try {
                    retChar = shiftedAlphabet1Array[c];
                }catch(ArrayIndexOutOfBoundsException indexError){
                    cInput++;
                    check = 1;
                    continue;
                }
                //check = 1
            //else
            } else {
                //ret[counter] = sh1[counter]
                try {
                    retChar = shiftedAlphabet2Array[c];
                }catch(ArrayIndexOutOfBoundsException indexError) {
                    cInput++;
                    check = 0;
                    continue;
                }
            }
            //return to the original case of the letter
            if (!capital){
                retChar = Character.toLowerCase(retChar);
            }
            ret[cInput] = retChar;
            cInput++;
        }
            return String.valueOf(ret);
    }
    public String decryptTwoKeys(String input){

        CesarCipherTwo cc = new CesarCipherTwo(26-this.key1 , 26-this.key2);
        char[] message = cc.encrypt(String.valueOf(input)).toCharArray();

        return String.valueOf(message);
    }

}
