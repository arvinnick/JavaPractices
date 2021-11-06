import edu.duke.*;

import java.util.Locale;

public class Part1 {

    public static int countCTG(String dna){
        dna = dna.toUpperCase();
        int count = 0;
        int indx = 0;
        System.out.println("c  "+indx);
        while(true){
            if(indx < 0){
                break;
            }
            if(indx >= 0) {
                indx = dna.indexOf("CTG");
                if(indx > 0){
                    dna = dna.substring(indx + 1);
                    count++;
                }
            }
            else{
                continue;
            }
        }
        return count;
    }
    public static void processGenes(StorageResource sr){
        
    }
    public static float CGRatio(String dna){
        dna = dna.toUpperCase();
        int cCount = 0;
        int cIndx;
        String cDna = dna;
        while (true) {
            cIndx = dna.indexOf("C");
            if (cIndx == -1) {
                break;
            } else {
                cCount++;
                cDna = cDna.substring(cIndx);
            }
        }
        int gCount = 0;
        int gIndx;
        String gDna = dna;
        while (true){
            gIndx = dna.indexOf("G");
            if (gIndx == -1){
                break;
            }
            else{
                gCount++;
                gDna = gDna.substring(gIndx);
            }
        }
        return (float)(gCount+cCount)/dna.length();
    }
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
    public static StorageResource getAllGenes(String dna){
        String prevDnas = "";
        StorageResource store = new StorageResource();
        while (true){
            String currentDna = findGene(dna);
            if (prevDnas.indexOf(currentDna) == -1){
                store.add(currentDna);
                prevDnas = prevDnas+currentDna;
            }
            else{
                break;
            }
        }
        return store;
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
    public static void printIterator (StorageResource store){
        for (String i:store.data()){
            System.out.println(i);
            System.out.println("  gaaaav  ");
        }
    }
    public static void testFindGene(){
        String dna1 = "GCTGCCATGACCGCTGCTAGAGCTAAG";
        String dna2 = "CATAACAATTAA";
        String dna3 = "CCAATTTGAACAATAACAGACCG";
        String dna4 = "AAATATGTGCACTGATTTATAATAA";
        String dna5 = "AAATTTATGGATAACTTAAGGAT";
        printIterator (getAllGenes(dna1));
        printIterator (getAllGenes(dna2));
        printIterator (getAllGenes(dna3));
        printIterator (getAllGenes(dna4));
        printIterator (getAllGenes(dna5));
        printIterator (getAllGenes("GCTGCCATGACCGCTGCTAGAGCTAAG"));

    }
    public static void testCGratio(){
        String dna = "CGCGCGAAAAAA";
        System.out.println(CGRatio(dna));
    }
    public static void testCTGcount(){
        String dna = "PublicstaticvoidtesCTGratioCTG";
        System.out.println(countCTG(dna));

    }
    public static void main(String[] args){
        testCTGcount();
    }
}
