public class StringSecondAssignmentPart2 {

    public static int howMany(String stringa, String stringb){
        int counter = 0;
        while (true){
            int index = stringb.indexOf(stringa);
            if (index == -1){
                break;
            }
            else{
                stringb = stringb.substring(index + stringa.length());
                counter++;
            }
        }
        return counter;
    }

    public static void testHowMany(){
        String stringa = "AA";
        String stringb = "AAAA";
        System.out.println(howMany(stringa,stringb));

        stringa = "AA";
        stringb = "AABAA";
        System.out.println(howMany(stringa,stringb));

        stringa = "AB";
        stringb = "AABA";
        System.out.println(howMany(stringa,stringb));

        stringa = "AAB";
        stringb = "AAAAB";
        System.out.println(howMany(stringa,stringb));

        stringa = "AAB";
        stringb = "AABAAAAABAABAAAAABAABAAAAAAAABAABAAAAAABAABAAAABAA";
        System.out.println(howMany(stringa,stringb));
    }

    public static void main(String[] args){
        testHowMany();
    }

}
