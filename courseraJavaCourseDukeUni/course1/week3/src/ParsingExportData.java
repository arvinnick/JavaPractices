import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ParsingExportData {
    public static void test(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
    }

    public static String countryInfo(CSVParser parser, String country){
        for(CSVRecord record : parser){
            String info = record.get("Country");
            if(info.contains(country)){
                return country+": "+record.get("Exports")+": "+record.get("Value (dollars)");
            }
        }
        return country+": not found";
    }

    public static int numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;
        for (CSVRecord record : parser) {
            String info = record.get("Exports");
            if(info.contains(exportItem)){
                count++;
            }
        }
        return count;
    }

    public static void bigExporters(CSVParser parser, String amount){
        for (CSVRecord record : parser) {
            String country = record.get("Country");
            String value = record.get("Value (dollars)");
            if(value.length() > amount.length()){
                System.out.println(country+" "+value);
            }
        }
    }

    public static void main(String[] args){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999");
    }
}
