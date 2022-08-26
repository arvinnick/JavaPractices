public class CesarCipher {

    final String alphabet;
    private String shiftedAlphabet;
    private char[] alphabetArray;
    private int key;

    public CesarCipher(int key){
        this.key = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.shiftedAlphabet = stringShifter(key);
        alphabetArray = alphabet.toCharArray();
    }
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
    public String encrypt(String input){
        //initialize the return
        String ret = "";
        //build the shiftedAlphabet
        String shiftedAlphabet = stringShifter(this.key);
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
    public String decrypt(String input){
        CesarCipher cc = new CesarCipher(26 - this.key);
        char[] message = cc.encrypt(input).toCharArray();

        int index = 0;
        char[] inputArray = input.toCharArray();
        for (int i = 0; index < inputArray.length - 1; i++){
            inputArray[index] = message[i];
            index = index + 1;
        }

        String res = String.valueOf(inputArray);
        return res;
    }
    public void main(String[] arg){

    }


    
}
