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
            String temp = record.get("Humidity");
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
        System.out.println(csv.toString());
//        System.out.println(csv.get("Humidity")+" at "+csv.get("TimeEST"));

    }

    public static CSVRecord lowestHumidityInManyFiles(){

        DirectoryResource dir = new DirectoryResource();
        Double min = null;
        CSVRecord driestRecordFiles = null;
        for (File file : dir.selectedFiles()) {
            FileResource f = new FileResource(file);
            CSVParser parser = f.getCSVParser();
            CSVRecord driestRecord = lowestHumidityInFile(parser);
            Double currentFileMin = Double.parseDouble(driestRecord.get("Humidity"));
            if (min == null || currentFileMin < min) {
                min = currentFileMin;
                driestRecordFiles = driestRecord;
            }
        }
        return driestRecordFiles;
    }

    public static void testlowestHumidityInManyFiles(){
        System.out.print(lowestHumidityInManyFiles().toString());
    }

    public static Double averageTemperatureInFile(CSVParser parser){
        Double tempSum = 0.0;
        Double counter = 0.0;
        for (CSVRecord record : parser){
            Double temp = Double.parseDouble(record.get("TemperatureF"));
            tempSum = tempSum+temp;
            counter = counter + (double)1;
        }
        return tempSum/counter;
    }

    public static void testaverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser csv = fr.getCSVParser();
        System.out.print(averageTemperatureInFile(csv));
    }

    public static Double averageTemperatureWithHighHumidityInFile (CSVParser parser, int value){
        Double tempSum = 0.0;
        Double counter = 0.0;
        for (CSVRecord record : parser){
            Double temp = Double.parseDouble(record.get("TemperatureF"));
            Double humidity = Double.parseDouble(record.get("Humidity"));
            if (humidity >= value){
                tempSum = tempSum+temp;
                counter = counter + (double)1;
            }
        }
        if (counter == 0.0){
            return -1.0;
        }
        else{
            return tempSum/counter;
        }
    }

    public static void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser csv = fr.getCSVParser();
        Double test = averageTemperatureWithHighHumidityInFile(csv,80);
        if (test<0){
            System.out.print("No temperatures with that humidity");
        }
        else{
            System.out.print(test);
        }
    }

    public static void main(String[] args){
        testColdestHourInFile();
    }
}
