import edu.duke.FileResource;

public class WordLengths {

    static int[] countWordLengths(FileResource resource, int[] counts){
        for (String word : resource.words()){
            int count = 0;
            char[] wordArray = word.toCharArray();
            //non-letter charachters at the last and first position of a words shouldn't be counted in the length of the word
            int i = 0;//counter of the array numbers
            for (char k : wordArray){
                if ((i == 0 || i == wordArray.length-1) && !Character.isLetter(k)){
                    continue;
                } else {
                    count++;
                }
                i++;
            }
            // For any words equal to or larger than the last index of the counts array, count them as the largest size
            // represented in the counts array.
            if (count <= counts.length){
                counts[count]++;
            } else {
                counts[counts.length-1]++;
            }
        }
        return counts;
    }

    static void testCountWordLengths(){
        FileResource f = new FileResource();
        int[] counts = new int[31];
        counts = countWordLengths(f, counts);
        int c = 0;
        for (int count : counts){
            System.out.println("number of letters:" + c + " count:" + count);
            c++;
        }
    }

    public static void main(String[] args){
        testCountWordLengths();
    }

}
