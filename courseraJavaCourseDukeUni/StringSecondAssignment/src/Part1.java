public class Part1 {

    public static int findStopCodon(String dna, int startIndex,String stopCodon){
        int indx = dna.indexOf(stopCodon,startIndex*3);
        if (indx != -1){
            return indx;
        }
        else {
            return dna.length();
        }
    }

    public static String findGene(String dna){
        int indx = dna.indexOf("ATG");
        if (indx == -1){
            return " ";
        }
        else {
            int indxTAA = findStopCodon(dna,indx,"TAA");
            int indxTGA = findStopCodon(dna,indx,"TGA");
            int indxTAG = findStopCodon(dna,indx,"TAG");
            if (indxTAG >= indxTGA){
                return dna.substring(indx,indxTGA);
            }
            if (indxTAG < indxTGA) {
                return dna.substring(indx,indxTAG);
            }
            if (indxTAG == -1 && indxTGA == -1){
                return " ";
            }
            else {
                return "";}
        }
    }

    public static void printAllGenes(String dna){
        String prevDnas = "";
        while (true){
            String currentDna = findGene(dna);
            if (prevDnas.indexOf(currentDna) == -1){
                System.out.println(currentDna);
                prevDnas = prevDnas+currentDna;
            }
            else{
                break;
            }
        }
    }



    public static void testFindStopCodon(){
        String dna1 = "GCTGCCATGACCGCTGCTAGAGCTAAG";
        String dna2 = "ATGCATAACAATTAA";
        String dna3 = "CCAATTATGAACAATAACAGACCG";
        String dna4 = "AAATATGTGCACTGATTTATAATAA";
        String dna5 = "AAATTTATGGATAACTTAAGGAT";
        String test1 = "TA";
        String test2 = "XY";
        System.out.println(findStopCodon(dna1,4,test2));
        System.out.println(findStopCodon(dna2,3,test2));
        System.out.println(findStopCodon(dna3,6,test1));
        System.out.println(findStopCodon(dna4,10,test2));
        System.out.println(findStopCodon(dna5,8,test1));
        System.out.println(findStopCodon(dna1,2,test2));
        System.out.println(findStopCodon(dna2,0,test1));
        System.out.println(findStopCodon(dna3,4,test2));
        System.out.println(findStopCodon(dna4,9,test1));
        System.out.println(findStopCodon(dna5,7,"GCTGCCATGACCGCTGCTAGAGCTAAG"));
    }

    public static void testFindGene(){
        String dna1 = "GCTGCCATGACCGCTGCTAGAGCTAAG";
        String dna2 = "CATAACAATTAA";
        String dna3 = "CCAATTTGAACAATAACAGACCG";
        String dna4 = "AAATATGTGCACTGATTTATAATAA";
        String dna5 = "AAATTTATGGATAACTTAAGGAT";
        System.out.println(findGene(dna1));
        System.out.println(findGene(dna2));
        System.out.println(findGene(dna3));
        System.out.println(findGene(dna4));
        System.out.println(findGene(dna5));
        System.out.println(findGene("GCTGCCATGACCGCTGCTAGAGCTAAG"));
    }

    public static void main(String[] args){
        testFindGene();
    }
}
