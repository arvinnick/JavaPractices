import java.util.ArrayList;

public class testingArrays {

    public static void main(String[] args){

        ArrayList<ArrayList<Integer>> twoDArray = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<10;i++){
            twoDArray.add(new ArrayList<Integer>());
            for(int j=0;j<10;j++){
                twoDArray.get(i).add(i*j);
            }
        }




        System.out.println();
        System.out.println(twoDArray);
    }
}
