public class StringSecondAssignmentPart1 {

    public static int findStopCodon(String dna,int startIndex, String stopCodon) {
        int index = dna.indexOf(stopCodon,startIndex);
        while (index != -1) {
            if ((index - startIndex) % 3 == 0) {
                return index;
            }
            else {
                index = dna.indexOf(stopCodon, index+1);
            }
        }
        return dna.length();
    }

    public static void testfindStopCodon(){
        String dna = "ATGTRTRFHGNLTNGHFKDL";
        System.out.println(findStopCodon(dna,3,"HFK"));

        String dna4 = "ATGTRTRFHGNLTNGTRTRFHGNLTNGHFKDL";
        System.out.println(findStopCodon(dna4,3,"HFK"));

        String dna1 = "ATGTRTRFHGNLTNHFKDL";
        System.out.println(findStopCodon(dna1,3,"HFK"));

        String dna2 = "ATGTRTRFHGNLTNaaHFKaaaHFKDL";
        System.out.println(findStopCodon(dna2,3,"HFK"));

    }

    public static String findGene(String dna){
        int indexATG = dna.indexOf("ATG");
        if (indexATG == -1){
            return "";
        }
        else {
            int indexTAA = findStopCodon(dna,indexATG,"TAA");
            int indexTAG = findStopCodon(dna,indexATG,"TAG");
            int indexTGA = findStopCodon(dna,indexATG,"TGA");
            int min = 999999999;
            int[] indexes = {indexTAA,indexTAG,indexTGA};

            for (int i : indexes){
                if (i < min){
                    min = i;
                }
            }
            if (min == dna.length()){
                return "";
            }
            else{
                return dna.substring(indexATG,min+3);
            }
        }
}

    public static void testFindGene(){
        String dna = "TRTNGHFKDLTLTFHGNRFHGNGLTFKDLRTRHN";//no ATG
        String dna1 = "TRTRFHATGGNLTNTHAADL";//no valid stop codon
        String dna2 = "TRTRFHGATGNLTNAATGAAAATAGDL";//two valid stop codons
        String dna3 = "TRTRFATGHGNLTNGTRTRFTAGTAATGALTNGHFKDL";
        String dna4 = "GGTGTFATGADLRLLHFGNGTTFTAATGARRRTAATTTNHGRRTTANKAART";


        System.out.println("dna:");
        System.out.println(findGene(dna));
        System.out.println("dna1:");
        System.out.println(findGene(dna1));
        System.out.println("dna2:");
        System.out.println(findGene(dna2));
        System.out.println("dna3:");
        System.out.println(findGene(dna3));
        System.out.println("dna4:");
        System.out.println(findGene(dna4));


    }

    public static void printAllGenes(String dna){
        int startIndex = 0;
        while (true){
            dna = dna.substring(startIndex);
            String gene = findGene(dna);
            if (gene.isEmpty()){
                break;
            }
            else{
                System.out.println(gene);
                startIndex = gene.length();
            }

        }

    }

    public static void main(String[] args) {
        testFindGene();

    }

}
