import edu.duke.StorageResource;
import edu.duke.URLResource;


public class StringThirdAssignmentPart3 {

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
    public static StorageResource getAllGenes(String dna){
        StorageResource store = new StorageResource();
        int startIndex = 0;
        dna = dna.substring(startIndex);
        String gene = findGene(dna);
        while (!gene.isEmpty()){
//            System.out.println(dna+"   "+startIndex);
            dna = dna.substring(startIndex);
            int startPoint = dna.indexOf("ATG");
            gene = findGene(dna);
            store.add(gene);
            startIndex = gene.length()+startPoint;
        }
        return store;
    }
    public static float cGRatio(String dna){
        dna = dna.toUpperCase();
        int Ccounter;
        int Gcounter;

        Ccounter = howMany("C",dna);
        Gcounter = howMany("G",dna);
        return (float)(Ccounter+Gcounter)/dna.length();
    }
    public static void processGene(StorageResource sr){

        int maxLegth = 0;
        int moreThanNine = 0;
        int cGratCounter = 0;
        String maxGeneDebug = "";
        for (String s : sr.data()){
            if (s.length() > 60){
                moreThanNine++;
//                System.out.println("data in s with legth more than 9");
//                System.out.println(s);
            }
            if (cGRatio(s)>0.35){
                cGratCounter++;
//                System.out.println("data in s with CG ratio more than .35");
//                System.out.println(s);
            }
            if (s.length()>maxLegth){
                maxLegth = s.length();
                maxGeneDebug = s;
            }
        }
        System.out.println("number of strings with more than 60 charachters:   "+moreThanNine);
        System.out.println("number of strings with CG ratio more than 0.35:   "+cGratCounter);
        System.out.println("maximum length:   "+maxLegth);
        System.out.println("maximum length gene:   "+maxGeneDebug);


    }
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
    public static void main(String[] args){
        /*
        The main script for quiz

         */

        URLResource url = new URLResource("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa");
        String dna = url.asString();
//        String dna = "ATGLNTLLJTAANATGRFGTHTGA";
        StorageResource genes = getAllGenes(dna);
        processGene(genes);
        System.out.println("number of genes:  "+   genes.size());
        System.out.println("number of CTG occurences in the DNA:   "+howMany("CTG",dna));

//        for (String gene : genes.data()){
//            System.out.println(gene);
//        }
    }

}
