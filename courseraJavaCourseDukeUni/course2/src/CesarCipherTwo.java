public class CesarCipherTwo {
    final private String alphabet;
    final private String shiftedAlphabet1;
    final private String shiftedAlphabet2;
    final private char[] alphabetArray;
    final private int key1;
    final private int key2;


    private String stringShifter(int key){
        String ret;
        //write the alphabet
        //take the tail (substrig by key)
        String head;
        String tail;
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

        return 26 - dkey;
    }
    public String encrypt(String input){
        boolean isNotCapital;
        char[] inputArrat = input.toCharArray();
        int check = 0;//if zero, take it from the
        for (int i = 0; i < inputArrat.length; i++) {//loop over the input
            isNotCapital = Character.isLowerCase(inputArrat[i]);
            inputArrat[i] = Character.toUpperCase(inputArrat[i]);
            //if check is zero
            if (check == 0) {
                //take the letter from shifted1 and put it in input array
                int indexOfShifted = alphabet.indexOf(inputArrat[i]);
                try {
                    inputArrat[i] = this.shiftedAlphabet1.charAt(indexOfShifted);
                } catch (StringIndexOutOfBoundsException indexError){
                    check = 1;
                    continue;
                }
                //set check as one
                check = 1;
                if (isNotCapital){
                    inputArrat[i] = Character.toLowerCase(inputArrat[i]);
                }
            }
            //if the check is one
            else {
                //take the letter from shifted2 and put it in input array
                int indexOfShifted = alphabet.indexOf(inputArrat[i]);
                try {
                    inputArrat[i] = this.shiftedAlphabet2.charAt(indexOfShifted);
                } catch (StringIndexOutOfBoundsException indexError){
                    check = 0;
                    continue;
                }
                //set check as zero
                check = 0;
                if (isNotCapital){
                    inputArrat[i] = Character.toLowerCase(inputArrat[i]);
                }
            }
        }
        return String.valueOf(inputArrat);
    }
    public String decryptTwoKeys(String input){

        CesarCipherTwo cc = new CesarCipherTwo(26-this.key1 , 26-this.key2);
        char[] message = cc.encrypt(String.valueOf(input)).toCharArray();

        return String.valueOf(message);
    }

}
