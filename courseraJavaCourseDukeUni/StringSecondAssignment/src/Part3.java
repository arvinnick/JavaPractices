public class Part3 {
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

    public static int countAllGenes(String dna){
        String prevDnas = "";
        int many = 0;
        while (true){
            String currentDna = findGene(dna);
            if (prevDnas.indexOf(currentDna) == -1){
                many++;
                prevDnas = prevDnas+currentDna;
            }
            else{
                break;
            }
            return many;
        }
    }


    public static void main(String[] args){

    }
}
