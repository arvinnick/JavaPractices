public class testingArrays {

    public static void main(String[] args){
        int[] oneDArray = new int[10];
        for(int i=0; i<10; i++){
            oneDArray[i] = i+1;
        }

        int[][] twoDArray;
        twoDArray = new int[10][10];

        for(int i=0; i<10;i++){
            for(int j =0; j<10;j++){
                twoDArray[i][j] = i*j;
            }
        }
        System.out.println(oneDArray[4]);
        System.out.println();
        System.out.println(twoDArray[4][5]);
    }
}
