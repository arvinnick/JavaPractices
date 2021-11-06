public class Part2 {

    public static int howMany(String stringa, String stringb){
        int many = 0;
        int indx = 0;
        int lengthb = stringb.length();
        int lengtha = stringa.length();
        while (indx < lengthb){
//            System.out.println("2  "+indx+lengtha);
            indx = stringb.indexOf(stringa);
//            System.out.println("1  "+lengthb);
            if (indx!= -1) {
                if (indx + lengtha < lengthb) {
                    stringb = stringb.substring(indx + lengtha);
                    many++;
                } else {
                    break;
                }
            }
            else{
                return many;
            }

        }
        return many;
    }

    public static void testHowMany(){
        String testb1 = "AAAA";//should give 2
        String testa1 = "AA";

        String testb2 = "AAA";//should give 1
        String testa2 = "AA";

        String testb3 = "AABA";//should give 1
        String testa3 = "AA";

        String testb4 = "BABA";//should give 2
        String testa4 = "BA";

        String testb5 = "CATABBBAB";//should give 2
        String testa5 = "AB";

        System.out.println(howMany(testa1,testb1));
        System.out.println(howMany(testa2,testb2));
        System.out.println(howMany(testa3,testb3));
        System.out.println(howMany(testa4,testb4));
        System.out.println(howMany(testa5,testb5));

    }
    public static void main(String[] args){
        testHowMany();
//    System.out.println("AAAA".substring(2));
    }
}
