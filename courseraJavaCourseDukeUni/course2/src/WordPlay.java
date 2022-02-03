public class WordPlay {
    static boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        for (char i : new char[] {'a', 'e', 'i', 'o', 'u'}){
          if (ch == i){
              return true;
          }
        }
        return false;
    }
    static void testIsVowel(){
        System.out.println(isVowel('d'));
        System.out.println(isVowel('a'));
        System.out.println(isVowel('e'));
        System.out.println(isVowel('v'));
        System.out.println(isVowel('D'));
        System.out.println(isVowel('A'));
        System.out.println(isVowel('E'));
        System.out.println(isVowel('V'));
    }

    static String replaceVowels(String phrase, char ch){
        StringBuilder ph = new StringBuilder(phrase);
        for (int i = 0; i < phrase.length(); i++){
            char cha = ph.charAt(i);
            if (isVowel(cha)){
                ph.setCharAt(i,ch);
            }
        }
        return ph.toString();
    }
    static void testReplaceVowels(){
        System.out.println(replaceVowels("Hello World", '*').equals("H*ll* W*rld"));
    }

    static String emphasize(String phrase, char ch){
        StringBuilder ph = new StringBuilder(phrase);
        for (int i = 0; i < phrase.length(); i++){
            char cha = ph.charAt(i);
            if (cha == ch) {
                if (i % 2 == 0) {
                    ph.setCharAt(i,'*');
                }
                if (i % 2 == 1) {
                    ph.setCharAt(i,'+');
                }

            }
        }
        return ph.toString();
    }
    static void testEmphasize(){
        System.out.println(emphasize("dna ctgaaactga", 'a').equals("dn* ctg+*+ctg+"));
    }



    public static void main(String[] args){
        testEmphasize();
    }
}
