package ICP_PROJECT;

import java.util.ArrayList;
import java.util.HashMap;

public class Routes {

    private final String airlineCode;
    private final String sourceAirportCode;
    private String destinationAirportCode;


    static HashMap<String, ArrayList<ArrayList<String>>> routeMap = new HashMap<>();


    public Routes(String airlineCode, String sourceAirportCode, String destinationAirportCode) {
        this.airlineCode = airlineCode;
        this.sourceAirportCode = sourceAirportCode;
        this.destinationAirportCode = destinationAirportCode;

    }

    @Override
    public java.lang.String toString() {
        return "Routes{ " +
                "airlinecode=" + airlineCode +
                ", sourceAirportCode='" + sourceAirportCode + '\'' +
                ",destinationAirportCode ='" + destinationAirportCode + '\'' +'}';

    }
// Getter methods
    public String getAirlineCode() {
        return airlineCode;
    }

    public String getSourceAirportCode() {
        return sourceAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public static HashMap<String, ArrayList<ArrayList<String>>> populateHashmap(){
        ArrayList<String[]> result = ReadFile.ReadFile("src/routes.csv");
        for (String[] element: result){
            ArrayList<ArrayList<String>> values = new ArrayList<>();
            Routes routeObjects = Objects.routesObject(element);
            String key = routeObjects.sourceAirportCode;
            ArrayList<String> routeCost = new ArrayList<>();
            routeCost.add(routeObjects.getDestinationAirportCode());

            if (routeMap.containsKey(key)){
                values = routeMap.get(key);
                values.add(routeCost);
                routeMap.put(key, values);
            }
            else{
                values.add(routeCost);
                routeMap.put(key, values);
            }
        }
        return routeMap;
    }
}
