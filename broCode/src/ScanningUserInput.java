import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ScanningUserInput {

    public static String s_question(String q){
        String answer = JOptionPane.showInputDialog(q);
        return answer;
    }
    public static Integer i_question(String q){
        String answer = JOptionPane.showInputDialog(q);
        Integer i_answer = Integer.parseInt(answer);
        return i_answer;
    }

    public static void main(String[] args){

        //getting the user's input by using a dialog box.
        String name = s_question("Please let me know your name");
        //showing the message alongside with the user input data in a message box.
        JOptionPane.showMessageDialog(null, "Hi "+name+"!");

        Integer year = i_question("When did you born?");
        JOptionPane.showMessageDialog(null, "you have been born at "+year+".");

        String food = s_question("what delicious do you like?");
        JOptionPane.showMessageDialog(null, "You like "+food+".");

        Random random = new Random();
        int luckInt = random.nextInt(10);

        JOptionPane.showMessageDialog(null, "Your lucky number is "+luckInt+".");



    }
}