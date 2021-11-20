public class FirstAssignmentPart2 {

    public static String findSimpleGenePart2(String dna,String startCodon, String stopCodon){

        dna = dna.toUpperCase();

        int indexStart = dna.indexOf(startCodon);
        int indexStop = dna.indexOf(stopCodon,indexStart);

        if (indexStart == -1 || indexStop == -1){
            return "";
        }

        else if ((indexStop-indexStart)%3 == 0){
            return dna.substring(indexStart,indexStop);
        }
        else{
            return "";
        }
    }

    public static void testFindSimpleGenePart2(){
        String dna1 = "RTATGHFJREDTAA";
        String dna2 = "TRGHSUANKFKD";
        String dna3 = "RTRTGHFJDTAA";
        String dna4 = "RTATGHFJDRTG";
        String dna5 = "RTATGHFJDTAA";

        System.out.println(dna1);
        System.out.println(findSimpleGenePart2(dna1,"ATG","TAA"));
        System.out.println();

        System.out.println(dna2);
        System.out.println(findSimpleGenePart2(dna2,"ATG","TAA"));
        System.out.println();

        System.out.println(dna3);
        System.out.println(findSimpleGenePart2(dna3,"ATG","TAA"));
        System.out.println();

        System.out.println(dna4);
        System.out.println(findSimpleGenePart2(dna4,"ATG","TAA"));
        System.out.println();

        System.out.println(dna5);
        System.out.println(findSimpleGenePart2(dna5,"ATG","TAA"));


    }

    public static void main(String[] args){
        testFindSimpleGenePart2();
    }
}
