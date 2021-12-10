import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

/*
the class for week4 quiz of the first course of the Duke University's Java course on Coursera
 */
public class quiz1course {

    public static void main(String[] args){
        testYearOfHighestRank();
    }

    /*
    prints the total number of boys and girls born in a file
     */
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

    /*
    gets year, name and gender; then it will return the rank of the name in the year and gender. If anything goes wrong,
    will return 0
     */
    public static int getRank(int year,String name, String gender) {

        //select files
        DirectoryResource dir = new DirectoryResource();
        String stringYear = Integer.toString(year);
        //dumb Java compiler. I have to declare this here:
        int numberEquivalentToTheName = 0;
        int rank = 0;
        //iterate over the files
        for (File file : dir.selectedFiles()) {
            //get the name of the files
            String nameOfTheFile = file.getName();
            //if the year part of the name is what we want:
            if (nameOfTheFile.substring(3, 7).equals(stringYear)) {
                //iterate over the rows of the file
                FileResource frRes = new FileResource(file);
                for (CSVRecord record : frRes.getCSVParser(false)) {
                    //if the gender of the row is what we want
                    if (record.get(1).equals(gender)) {
                        //if the name is what we want
                        if (record.get(0).equals(name)) {
                            //get the number equivalent to the name (number for this name)
                            numberEquivalentToTheName = Integer.parseInt(record.get(2));
                            //set rank to 1
                            rank = 1;
                            break;
                        }
                        else{
                            rank = -1;
                        }
                    }
                    else{
                        continue;
                    }
                }
                if (rank == -1){
                    //the name is not in the file. return -1
                    return -1;
                }
                //iterate over the rows of the file
                for (CSVRecord record : frRes.getCSVParser(false)) {
                    //if the gender of the row is what we want
                    if (record.get(1).equals(gender)) {
                        //if the name is what we want
                        if (record.get(0).equals(name)) {
                            //return rank
                            return rank;
                        }
                        //else
                        else {
                            //if the number the parameter's name is less than or equal to the number for actual parameter name
                            int currentRowNumber = Integer.parseInt(record.get(2));
                            if (numberEquivalentToTheName <= currentRowNumber) {
                                // rank++;
                                rank++;
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

    /*
    should print 5 "true"s
     */
    public static void testGetRank(){
        System.out.println(getRank(2014,"javad","M")==-1);
        System.out.println(getRank(2013,"Ava","F")==5);
        System.out.println(getRank(2013,"Isabella","M")==-1);
        System.out.println(getRank(2013,"Noah","M")==1);
        System.out.println(getRank(2012,"William","M")==5);




    }

    public static String getName(int year, int rank, String gender){
        /*
        first, I will find maximum (rank number 1).
        then I will find min.
        then until min==max, I will see if the current row is equal to max and if the rank is what I want it to be.
        Or else, I will first set the max equal to the current row, then increment the rank, then I will start over the
        for each row loop.
         */
        //selecting and looping over the files
        String stringYear = Integer.toString(year);
        DirectoryResource dir = new DirectoryResource();
        for(File file : dir.selectedFiles()) {
            if (stringYear.equals(file.getName().substring(3, 7))) {
                //seting max into zero
                int max = 0;
                //for each row
                FileResource fr = new FileResource(file);
                for (CSVRecord row : fr.getCSVParser(false)) {
                    if (row.get(1).equals(gender)) {
                        //if row number is more than max
                        if (Integer.parseInt(row.get(2)) > max) {
                            //update max into the row number
                            max = Integer.parseInt(row.get(2));
                        }
                        //else
                        else {
                            //continue
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
                //setting min to inf
                int min = Integer.MAX_VALUE;
                //for each row
                for (CSVRecord row : fr.getCSVParser(false)) {
                    if (row.get(1).equals(gender)) {
                        //if row number is less than min
                        if (Integer.parseInt(row.get(2)) < min) {
                            //update min into the row number
                            min = Integer.parseInt(row.get(2));
                        }
                        //else
                        else {
                            //continue
                            continue;
                        }
                    } else {
                        continue;
                    }
                }

                //until max == min
                while (min < max) {
                    //rank so far = 1
                    int rankSoFar = 1;
                    //for each row
                    for (CSVRecord row : fr.getCSVParser(false)) {
                        if (row.get(1).equals(gender)) {
                            //if the row's number == max TODO: there is a problem in this line. It doesn't work.
                            if (Integer.parseInt(row.get(2)) <= max) {
                                //if the rank so far is equal to actual parameter rank
                                if (rankSoFar == rank) {
                                    //return rows name
                                    return row.get(0);
                                }
                                //else
                                else {
                                    //update max into the current row number
                                    max = Integer.parseInt(row.get(2));
                                    //increment rank
                                    rankSoFar++;
                                }
                            }
                            //else
                            else {
                                //continue
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            } else {
                continue;
            }
        }
        return "NO NAME";
    }

    /*
    Will print some "true"s if getName works well
     */
    public static void testGetName(){
        System.out.println(getName(2013,2,"F").equals("Emma"));
        System.out.println(getName(2012,1,"F").equals("Sophia"));
        System.out.println(getName(2012,53,"F").equals("NO NAME"));
        System.out.println(getName(2013,4,"M").equals("Mason"));


    }

    /*
    will take the rank of the name is year, and then print the name of the same rank in the new year
     */
    public static void whatIsNameInYear(String name,int year, int newYear, String gender){
        int rank = getRank(year,name,gender);
        String newName = getName(newYear,rank,gender);
        System.out.println(name+" born in "+year+" would be "+newName+" if she was born in "+newYear+".");
    }

    /*
    will print "Isabella born in 2012 would be Sophia if she was born in 2014." if "whatIsNameInYear" works good
     */
    public static void testWhatIsNameInYear(){
        whatIsNameInYear("Isabella",2012,2014,"F");

    }

    /*
    This function will ask user to select multiple files and will
     */
    public static int yearOfHighestRank(String name, String gender){

        /*
         *we already know how to get the rank of a name in a file. We need to modify the getRank function so that each
         * time it iterates over a file, it doesn't check the year from the name; it just stores it in a variable. Also,
         * it doesn't return the rank, but compare it to a max. So, we will have a maxSoFar (year).
         */
        //declare year
        int year = 0;
        //declare rank
        int rank = -1;
        //declare maxSoFar
        int maxSoFar = 0;
        //declare yearSoFar
        int yearSoFar = -1;

        //select files
        DirectoryResource dir = new DirectoryResource();
        String stringYear = Integer.toString(year);
        //dumb Java compiler. I have to declare this here:
        int numberEquivalentToTheName = 0;
        //iterate over the files
        for (File file : dir.selectedFiles()) {
            //get the name of the files
            String nameOfTheFile = file.getName();
            //if the year part of the name is what we want:
            year = Integer.parseInt(nameOfTheFile.substring(3, 7));
            //iterate over the rows of the file
            FileResource frRes = new FileResource(file);
            for (CSVRecord record : frRes.getCSVParser(false)) {
                //if the gender of the row is what we want
                if (record.get(1).equals(gender)) {
                    //if the name is what we want
                    if (record.get(0).equals(name)) {
                        //get the number equivalent to the name (number for this name)
                        numberEquivalentToTheName = Integer.parseInt(record.get(2));
                        //set rank to 1
                        rank = 1;
                        break;
                    }
                    else{
                        rank = -1;
                    }
                }
                else{
                    continue;
                }
            }
            //iterate over the rows of the file
            for (CSVRecord record : frRes.getCSVParser(false)) {
                //if the gender of the row is what we want
                if (record.get(1).equals(gender)) {
                    //if the name is what we want
                    if (record.get(0).equals(name)) {
                        //return rank
                        break;
                    }
                    //else
                    else {
                        //if the number the parameter's name is less than or equal to the number for actual parameter name
                        int currentRowNumber = Integer.parseInt(record.get(2));
                        if (numberEquivalentToTheName <= currentRowNumber) {
                            // rank++;
                            rank++;
                        }
                    }
                }
            }
            if (maxSoFar < rank){
                maxSoFar = rank;
                yearSoFar = year;
            }
        }
        return yearSoFar;
    }

    public static void testYearOfHighestRank(){
        System.out.println(yearOfHighestRank("Mason","M"));
    }
}
