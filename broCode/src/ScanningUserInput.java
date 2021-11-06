import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ScanningUserInput {

    public static void main(String[] args){

        //getting the user's input by using a dialog box.
        String name = JOptionPane.showInputDialog("Please let me know your name");
        //showing the message alongside with the user input data in a message box.
        JOptionPane.showMessageDialog(null, "Hi "+name+"!");

        int year = Integer.parseInt(JOptionPane.showInputDialog("When did you born?"));
        JOptionPane.showMessageDialog(null, "you have been born at "+year+".");

        String food = JOptionPane.showInputDialog("what delicious do you like?");
        JOptionPane.showMessageDialog(null, "You like "+food+".");

        Random random = new Random();
        int luckInt = random.nextInt(10);

        JOptionPane.showMessageDialog(null, "Your lucky number is "+luckInt+".");



    }
}