public class StringSecondAssignmentPart1 {

    public static int findStopCodon(String dna,int startIndex, String stopCodon) {
        int index = dna.indexOf(stopCodon,startIndex);
        int count = dna.length();
        while (index != -1 && count > 0) {
            count--;
            if ((index - startIndex) % 3 == 0) {
                return index;
            }
            else {
                index = dna.indexOf(stopCodon, index);
            }
        }
        return dna.length();
    }

    public static void testfindStopCodon(){
        String dna = "ATGTRTRFHGNLTNGHFKDL";
        System.out.println(findStopCodon(dna,3,"HFK"));

        String dna1 = "ATGTRTRFHGNLTNHFKDL";
        System.out.println(findStopCodon(dna1,3,"HFK"));

        String dna2 = "ATGTRTRFHGNLTNaaHFKaaaHFKDL";
        System.out.println(findStopCodon(dna2,3,"HFK"));

    }

    public static String findGene(String dna){

        int atgIndex = dna.indexOf("ATG");
        if (atgIndex == -1){
            return "";
        }
        return "";
    }

    public static void main(String[] args){
        testfindStopCodon();
//        System.out.println(-1039018>0);
    }

}
