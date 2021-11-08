public class FirstAssignmentPart1 {

    public static String findSimpleGene(String dna){

        int indexATG = dna.indexOf("ATG");
        int indexTAA = dna.indexOf("TAA",indexATG);

        if (indexATG == -1 || indexTAA == -1){
            return "";
        }

        else if ((indexTAA-indexATG)%3 == 0){
            return dna.substring(indexATG,indexTAA);
        }
        else{
            return "";
        }
    }

    public static void testFindSimpleGene(){
        String dna1 = "RTATGHFJREDTAA";
        String dna2 = "TRGHSUANKFKD";
        String dna3 = "RTRTGHFJDTAA";
        String dna4 = "RTATGHFJDRTG";
        String dna5 = "RTATGHFJDTAA";

        System.out.println(dna1);
        System.out.println(findSimpleGene(dna1));
        System.out.println();

        System.out.println(dna2);
        System.out.println(findSimpleGene(dna2));
        System.out.println();

        System.out.println(dna3);
        System.out.println(findSimpleGene(dna3));
        System.out.println();

        System.out.println(dna4);
        System.out.println(findSimpleGene(dna4));
        System.out.println();

        System.out.println(dna5);
        System.out.println(findSimpleGene(dna5));


    }

    public static void main(String[] args){
        testFindSimpleGene();
    }
}
