import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class WeatherDataAnalyse {

    public static CSVRecord coldestTempInFile(CSVParser parser){
        Double min = null;
        CSVRecord minRecord = null;
        for (CSVRecord record : parser){
            Double temp = Double.parseDouble(record.get("TemperatureF"));
            if (temp == -9999.0){
                continue;
            }
            else if (min == null || temp<min){
                min = temp;
                minRecord = record;
            }
        }
        return minRecord;
    }

    public static void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser csv = fr.getCSVParser();
        System.out.print(coldestTempInFile(csv));
    }

    public static String fileWithColdestTemperature(){

        DirectoryResource dir = new DirectoryResource();
        Double min = null;
        String coldestFile = null;
        for (File file : dir.selectedFiles()) {
            FileResource f = new FileResource(file);
            CSVParser parser = f.getCSVParser();
            CSVRecord coldestRecord = coldestTempInFile(parser);
            Double currentFileMin = Double.parseDouble(coldestRecord.get("TemperatureF"));
            if (min == null || currentFileMin < min) {
                min = currentFileMin;
                coldestFile = file.toString();
            }
        }
        return coldestFile;
    }

    public static void testFileWithColdestTemperature(){
        System.out.print(fileWithColdestTemperature());
    }

    public static CSVRecord lowestHumidityInFile(CSVParser parser){
        Double min = null;
        CSVRecord minRecord = null;
        for (CSVRecord record : parser) {
            String temp = record.get("TemperatureF");
            if (temp.equals("N/A")) {
                continue;
            } else {
                Double doubleTemp = Double.parseDouble(temp);
                if (min == null || doubleTemp < min) {
                    min = doubleTemp;
                    minRecord = record;
                }
            }
        }
        return minRecord;
    }

    public static void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        String humidity = csv.toString();
        System.out.println(humidity);

    }

    public static void main(String[] args){
        testLowestHumidityInFile();
    }
}
