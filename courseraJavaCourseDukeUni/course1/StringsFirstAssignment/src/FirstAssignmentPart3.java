public class FirstAssignmentPart3 {

    public static boolean twoOccurrences(String stringA, String stringB) {
        /*
        returns true if there are 2 occurrences of astrinA in stringB.
         */
        int count = 0;
        int index = stringB.indexOf(stringA);
        if (index == -1){
            return false;
        }
        else {
            do {
                count++;
                index = stringB.indexOf(stringA);
                stringB = stringB.substring(index + 1);
            } while (index != -1);
            if (count > 2) {
                return true;

            } else {
                return false;
            }
        }
    }

    public static String lastPart(String stringA, String stringB){

        int index = stringB.indexOf(stringA);
        if (index == -1){
            return stringB;
        }
        else {
            return stringB.substring(index+1);
        }
    }

    public static void testtwoOccurrences(){
        String dna1 = "RTATGHFJRTDTAA";
        String dna2 = "TRGHSUANKFKD";

        System.out.println(twoOccurrences("RT",dna1));
        System.out.println();
        System.out.println(twoOccurrences("RT",dna2));

    }

    public static void testLastPart(){
        System.out.println(lastPart("na","banana"));
        System.out.println(lastPart("zoo","forest"));
    }
    public static void main(String[] args){
        testLastPart();
    }
}
