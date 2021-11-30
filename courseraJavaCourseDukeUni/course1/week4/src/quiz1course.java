import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class quiz1course {

    public static void main(String[] args){
        TestGetRank();
    }

    public static void totalBirths(FileResource fr){
        int totalGirls = 0;
        int totalBoys = 0;

        for (CSVRecord record : fr.getCSVParser(false)){
            if (record.get(1).equals("F")){
                int Girls = Integer.parseInt(record.get(2));
                totalGirls = totalGirls + Girls;
            }
            if (record.get(1).equals("M")){
                int Boys = Integer.parseInt(record.get(2));
                totalBoys = totalBoys + Boys;
            }
        }
        System.out.println("Boys: " + totalBoys);
        System.out.println("Girls: " + totalGirls);
    }

    public static void TestTotalBirths(){
        FileResource fr = new FileResource();
        totalBirths(fr);
    }

    public static int getRank(int year,
                               String name,
                               String gender){
        DirectoryResource dir = new DirectoryResource();
        String yearString = Integer.toString(year);
        int exportedNumber = 0;
        int rank = 0;
        for (File fr : dir.selectedFiles()){
            if (fr.getName().substring(3,7).equals(yearString)) {
                FileResource frRes = new FileResource(fr);
                for (CSVRecord record : frRes.getCSVParser()){
                    if (record.get(1).equals(gender)){
                        if (record.get(0).equals(name)){
                            exportedNumber = Integer.parseInt(record.get(2));
                        }
                    }
                }
                if (exportedNumber==0){
                    continue;
                }
                else {
                    for (CSVRecord record : frRes.getCSVParser(false)) {
                        if (record.get(1).equals(gender)) {
                            if (Integer.parseInt(record.get(2)) > exportedNumber) {
                                rank++;
                            }
                            else if (Integer.parseInt(record.get(2)) == exportedNumber) {
                                if (record.get(0).equals(name)){
                                    continue;
                                }
                                else{
                                    rank++;
                                }
                            }

                        }
                    }
                }
            }
            else{
                continue;
            }
        }
        return rank;
    }

    public static void TestGetRank(){
        System.out.println(getRank(2013,"William","M"));
    }

    public static String getName(int year,
                                 int rank,
                                 String gender){
        return "";

    }

}
