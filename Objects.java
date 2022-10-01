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

        if(airportList[0].equals(885) || airportList[0].equals(84)||
                airportList[0].equals(111) || airportList[0].equals(2255) ||
                airportList[0].equals(1267) || airportList[0].equals(232) ||
                airportList[0].equals(167)  || airportList[0].equals(84)  ||
                airportList[0].equals(761) || airportList[0].equals(232) ||
                airportList[0].equals(3048) || airportList[0].equals(496)|| airportList[0].equals(357)){

            try{
                Latitude = Double.parseDouble(airportList[6]);
                Longitude =  Double.parseDouble(airportList[7]);

            } catch (NumberFormatException nFE){
                //   System.out.println("Number Format Exception: " + nFE.getMessage());
            }
            airportName =  airportList[1] + airportList[2];
            City = airportList[3];
            Country = airportList[4];
            iataCode = airportList[5];
            icaoCode  = airportList[6];
            DST = airportList[11];
            TZ = airportList[12];
            Type = airportList[13];
            dataSource  =  airportList[14];

        } else if (airportList[0].equals(671) || airportList[0].equals(21) ||
                airportList[0].equals(1789) || airportList[0].equals(129)) {
            try{
                airportId  =  Integer.parseInt(airportList[0]);
                Latitude = Double.parseDouble(airportList[6]);
                Longitude  = Double.parseDouble(airportList[7]);
                Altitude = Double.parseDouble(airportList[8]);
                timezone = Double.parseDouble(airportList[9]);

            } catch(NumberFormatException nFE){
//                System.out.println("Number Format Exception: ");
//                nFE.printStackTrace();
            }

            airportName = airportList[1];
            City = airportList[2] + airportList[3];
            Country = airportList[4];
            iataCode = airportList[5];
            icaoCode = airportList[6];
            DST = airportList[11];
            TZ = airportList[12];
            Type = airportList[13];
            dataSource = airportList[14];


        } else {
            try{
                airportId  =  Integer.parseInt(airportList[0]);
                Latitude = Double.parseDouble(airportList[6]);
                Longitude  = Double.parseDouble(airportList[7]);
                Altitude = Double.parseDouble(airportList[8]);
                timezone = Double.parseDouble(airportList[9]);

            } catch(NumberFormatException nFE){
//                System.out.println("Number Format Exception: " + nFE.getMessage());
            }
            airportName = airportList[1];
            City = airportList[2];
            Country = airportList[3];
            iataCode = airportList[4];
            icaoCode = airportList[5];
            DST = airportList[10];
            TZ = airportList[11];
            Type = airportList[12];
            dataSource = airportList[13];

        }

        return new Airports(airportId, airportName, City, Country, iataCode, icaoCode,
                Latitude, Longitude, Altitude, timezone, DST, TZ, Type, dataSource);

    }

    /** Airline object creation that takes string array input
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

    /** route object that takes a string array
     * @param routeList
     * @return
     */
    public static Routes routesObject(String[] routeList) {
        String airlineCode = routeList[0];
        String sourceAirportCode = routeList[2];
        String destinationAirportCode = routeList[4];
        return new Routes(airlineCode, sourceAirportCode, destinationAirportCode);

    }

    /**
     * Extreme case handling
     */
    public static void fileReading() {
        BufferedReader reader = null;
        int counter = 0;
        try {
            File file = new File("src/airports.csv");
            reader = new BufferedReader(new FileReader(file));
            String content;
            String[] fieldObjects;
            while ((content = reader.readLine()) != null) {
                fieldObjects = content.split(",");
                if (fieldObjects.length > 14) {
                    counter += 1;
                    System.out.print(("Index of Extra Comma" + counter + "is: "));
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
     * @return airportID
     */

    public static ArrayList<Integer> getAirportId(String City,String Country){
        ArrayList<Integer> airportId =  new ArrayList<>();
        for (Airports obj: Main.airportObjects){
            if(obj.getCity().equals(City) && obj.getCountry().equals(Country)){
                airportId.add(obj.getAirportId());
            }
        }return airportId;
    }
    /**
     *Testing Airport Object by passing in AirportID
     * @param airportCode
     * @return airport object
     */
   public static Airports getAirportByCode (int airportCode){
      Airports airportObjects = new Airports();
       for (Airports airport_obj: Main.airportObjects){
            if (java.util.Objects.equals(airport_obj.getIataCode(),airportCode)){
                airportObjects  = airport_obj;
              }
        }return airportObjects;
//   }
}}
