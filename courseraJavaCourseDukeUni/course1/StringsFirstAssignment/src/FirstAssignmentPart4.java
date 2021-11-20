import edu.duke.URLResource;

public class FirstAssignmentPart4 {


    public static void urlFinder(String url){
        URLResource urlResource = new URLResource(url);
        
        for (String s : urlResource.words()){
            String sCopy = s.toLowerCase();
            if(sCopy.contains("youtube.com")){
                int index = s.indexOf("\"");
                int lastIndex = s.lastIndexOf("\"");
                System.out.println(s.substring(index,lastIndex+1));
            }
        }
    }

    public static void main(String[] args){
        urlFinder("http://www.dukelearntoprogram.com/course2/data/manylinks.html");

    }
}




