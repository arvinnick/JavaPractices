public class StringThirdAssignmentPart2 {

    public static float cGRatio(String dna){
        dna = dna.toUpperCase();
        int CGCounter = 0;
        for (int i = 0; i < dna.length(); i++){
            String CG = dna.substring(i,i+1);
            if (CG.equalsIgnoreCase("C") || CG.equalsIgnoreCase("G")){
                CGCounter++;
            }
        }
        return (float)CGCounter/dna.length();
    }

    public static void testCGRatio(){
        String dna = "sdgjslnjcccccciiohlfdllewhlwlcgcgcgcgc";
        System.out.println(cGRatio(dna));
    }


    public static void main (String[] args){
        testCGRatio();
    }
}
