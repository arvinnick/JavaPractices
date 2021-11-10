public class StringSecondAssignmentPart3 {
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

    public static int countGene(String dna) {
        int startIndex = 0;
        int counter = 0;
        while (true) {
            dna = dna.substring(startIndex);
            String gene = findGene(dna);
            if (gene.isEmpty()) {
                break;
            } else {
                counter++;
                startIndex = gene.length();
            }

        }
        return counter;
    }
}
