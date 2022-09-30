package ICP_PROJECT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.*;

/**
 *
 */

public class Objects {
    /**
     * Creating Airport Objects
     */

    public static Airports airportObjects(String[] airportList) {
        int airportId = 0;
        String airportName = "";
        String City = "";
        String Country = "";
        String iataCode = "";
        String icaoCode = "";
        double Latitude = 0.0;
        double Longitude = 0.0;
        double Altitude = 0.0;
        double timezone = 0.0;
        String DST = "";
        String TZ = "";
        String Type = "";
        String dataSource = "";

        try {
            airportId = Integer.parseInt(airportList[0]);
            Latitude = Double.parseDouble(airportList[6]);
            Longitude = Double.parseDouble(airportList[7]);
            Altitude = Double.parseDouble(airportList[8]);
            timezone = Double.parseDouble(airportList[9]);

        } catch (NumberFormatException nFE) {
            System.out.println("Number Format Exception" + nFE.getMessage());
        }
        airportName = airportList[1] + airportList[2];
        City = airportList[3];
        Country = airportList[4];
        iataCode = airportList[5];
        icaoCode = airportList[6];
        DST = airportList[11];
        TZ = airportList[12];
        Type = airportList[13];
        dataSource = airportList[13];

        return new Airports(airportId, airportName, City, Country, iataCode, icaoCode,
                Latitude, Longitude, Altitude, timezone, DST, TZ, Type, dataSource);

    }

    /**
     * @param airlineList
     * @return
     */
    public static Airlines airlinesObject(String[] airlineList) {
        int airlineId = 0;
        try {
            airlineId = Integer.parseInt(airlineList[1]);
        } catch (NumberFormatException nFE) {
            System.out.println("Number Format Exception:" + nFE.getMessage());
        }
        String airlineName = airlineList[1];
        String alias = airlineList[2];
        String iata_Code = airlineList[3];
        String icao_Code = airlineList[4];
        String callSign = airlineList[5];
        String Country = airlineList[6];
        String activeState = airlineList[7];

        return new Airlines(airlineId, airlineName, alias, iata_Code,
                icao_Code, callSign, Country, activeState);

    }

    /**
     * @param routeList
     * @return
     */
    public static Routes routesObject(String[] routeList) {
        int airlineID = 0;
        int sourceAirportID = 0;
        int destinationAirportId = 0;
        int Stops = 0;

        try {
            airlineID = Integer.parseInt(routeList[1]);
            sourceAirportID = Integer.parseInt(routeList[3]);
            destinationAirportId = Integer.parseInt(routeList[5]);
            Stops = Integer.parseInt(routeList[7]);

        } catch (NumberFormatException nFE) {
            System.out.println("Number format Exception" + nFE.getMessage());
        } catch (ArrayIndexOutOfBoundsException oFB) {
            System.out.println("Array Out Of Bounds Exception: " + oFB.getMessage());
        }
        String airlineCode = routeList[0];
        String sourceAirportCode = routeList[2];
        String destinationAirportCode = routeList[4];
        String codeShare = routeList[6];
        String equipment = routeList[routeList.length - 1];

        return new Routes(airlineCode, airlineID, sourceAirportCode, sourceAirportID, destinationAirportCode,
                destinationAirportId, codeShare, Stops, equipment);

    }

    /**
     *
     */
    public static void fileReading() {
        BufferedReader reader = null;
        // int counter = 0;
        try {
            File file = new File("src/airports.csv");
            reader = new BufferedReader(new FileReader(file));
            String content;
            String[] fieldObjects;
            while ((content = reader.readLine()) != null) {
                fieldObjects = content.split(",");
                if (fieldObjects.length > 14) {
                    // counter += 1;
                    // System.out.print(("Index of Extra Comma" + counter + "is: "));
                    System.out.println(fieldObjects[0]);
                    System.out.println(content);
                    System.out.println();
                }
            }


        } catch(FileNotFoundException fNE){
            fNE.printStackTrace();
    }catch(IOException ie) {
            ie.printStackTrace();

    }
    finally{
            try{
                if (reader != null)
                    reader.close();
            } catch(IOException ep) {
                ep.printStackTrace();
            }
        }
    }
    /**
     *
     * checks for existence of airportID for city and country name
     * @param City
     * @param Country
     * @return
     */

    public static ArrayList<Integer> getairportId(String City,String Country){
        ArrayList<Integer> airportId =  new ArrayList<>();
        for (Airports obj: Main.airportObjects){
            if(obj.getCity().equals(City) && obj.getCountry().equals(Country)){
                airportId.add(obj.getAirportId());
            }
        }return airportId;
    }
    /**
     *Testing Airport Object by passing in AirportID
     * @param airportId
     * @return
     */
//   public static Airports getAirportByID (int airportId){
//      Airports airportObjects = new Airports()
//       for (Airports airport_obj: Main.airportsObjects){
//            if (airports_obj.getAirportID() == airportId){
//                airportObjects  = airport_obj;
//              }
//        }return airportObjects;
//   }
}
