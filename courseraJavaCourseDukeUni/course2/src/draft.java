import java.lang.String;

//this is just a scetch file
public class draft {

    public static int findAccurances(String message, char alphabet){
        int accurance = 0;
        for (int i = 0; i < message.length(); i++){
            if (message.charAt(i) == alphabet){
                accurance++;
            }
        }
        return accurance;
    }

    public static void main(String[] args){
        String message = "Hi, do you want a lollipop today? I own many good flavors, but banana is outstanding.";
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w',
                           'x','y','z'
        };
        for (int i = 0; i < alphabet.length; i++){
            System.out.println(String.valueOf(alphabet[i]) + ":" + String.valueOf(findAccurances(message, alphabet[i])));
        }

    }
}
