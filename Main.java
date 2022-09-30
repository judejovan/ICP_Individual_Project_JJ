package ICP_PROJECT;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    /**
     * arraylist that has airport,airline,route objects
     */
    public static ArrayList<Airports> airportObjects =  new ArrayList<>();
    public static ArrayList<Airlines> airlineObjects =  new ArrayList<>();
    public static ArrayList<Routes> routeObjects = new ArrayList<>();

    public static void main(String[] args){
        /**
         * looping through array from  file reading
         * and appending to airportsObject
         * @param fileName
         */


        ArrayList<String []>  Airports_fileArray = new ArrayList<>(ReadFile.ReadFile("src/airports.csv"));
        for (String[] array: Airports_fileArray){
            Airports airportsObject = Objects.airportObjects(array);
            airportObjects.add(airportsObject);
        }

        /**
         * looping through array from  file reading
         * and appending to arlineObjects
         * @param fileName
         */

//       ArrayList<String[]> Airlines_FileArray = new ArrayList<>(ReadFile.ReadFile("src/airlines.csv"));
//        for (String [] array: Airlines_FileArray){
//            Airlines airlineObject = Objects.airlineObject(array);
//            airlineObjects.add(airlineObject);
//        }
//        /**
//        * looping through array from file reading
//         * and appending to routeObjects
//         * @param fileName
//         */
            ArrayList<String[]> Routes_fileArray = new ArrayList<>(ReadFile.ReadFile("src/routes.csv"));
            for (String[] array: Routes_fileArray){
                Routes routesObject = Objects.routesObject(array);
                routeObjects.add(routesObject);
            }
//            Testing for execution
//               System.out.println(airportObjects);
//               System.out.println(airlineObjects);
//               System.out.println(routeObjects);
//                 Objects.fileReading();
//
//
        /**
         * Testing
         *
         */

//        System.out.println(Objects.getairportId("Accra","Ghana"));
//
//        Scanner input = new Scanner(System.in);
//        System.out.println("City Name:");
//        String City = input.nextLine();
//        System.out.println("Country Name:");
//        String Country = input.nextLine();
//        System.out.println("Airport ID for" + City+","+Country+" is: ");
//        System.out.println(Objects.getairportId(City,Country));
//        System.out.println();
//

        /**
         *
         * Getting the Airport object after parsing  ID
         */
//
//           System.out.println(Objects.getAirportID(248));
//
//////

    }

}
