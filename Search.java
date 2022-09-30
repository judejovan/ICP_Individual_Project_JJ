package ICP_PROJECT;

import java.io.*;
import java.util.*;


public class Search {
    /**
     * Instance Variables
     * The S starting point and the destination
     */
    private static String StartingAirportcode;
    private static String DestinationAirportcode;

    /**
     * Constructor for the search class
     *
     * @param StartingAirportcode
     * @param DestinationAirportcode
     */
    public Search(String StartingAirportcode, String DestinationAirportcode) {
        this.StartingAirportcode = StartingAirportcode;
        this.DestinationAirportcode = DestinationAirportcode;
    }

    /**
     * Goal test method that checks if   location
     * reached is the goal
     *
     * @param location
     * @return
     */
    public static boolean goal_test(String location) {
        return false;
    }
}