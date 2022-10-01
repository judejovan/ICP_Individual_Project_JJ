package ICP_PROJECT;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;

public class Airlines {
    private final int airlineId;
    private final String airlineName;
    private final String alias;
    private String iata_Code;
    private String icao_Code;
    private final  String callSign;
    private final String Country;
    private final String activeState;

    /**
     *
     * @param airlineId
     * @param airlineName
     * @param alias
     * @param iata_Code
     * @param icao_Code
     * @param callSign
     * @param Country
     * @param activeState
     */

    public Airlines(int airlineId, String airlineName, String alias, String iata_Code, String icao_Code,String callSign, String Country, String activeState){
        this.airlineId = airlineId;
        this.airlineName =  airlineName;
        this.alias = alias;
        this.iata_Code  = iata_Code;
        this.icao_Code =  icao_Code;
        this.callSign = callSign;
        this.Country = Country;
        this.activeState = activeState;
    }

    @java.lang.Override
    public java.lang.String toString(){
        return "Airline{ " +
                "airlineId=" +   airlineId +
                ", airlineName= '" + airlineName + '\'' +
                ", alias='" + alias + '\'' +
                ", iataCode ='" + iata_Code +  '\'' +
                ",icao_code ='" + icao_Code + '\'' +
                ", Country=" + Country   + '\''+
                ", Active State ='" + activeState + '\'' +
                '}';
    }

    /**
     * Getter Methods for Airline class fields
     */
    public int getAirlineId(){
        return airlineId;
    }
    public String getAirlineName() {
        return airlineName;
    }
    public String getAlias() {
        return alias;
    }
    public String getIata_Code() {
        return iata_Code;
    }
    public String getIcao_Code() {
        return icao_Code;
    }
    public String getCallSign() {
        return callSign;
    }
    public String getCountry() {
        return Country;
    }
    public String getActiveState() {
        return activeState;
    }
}







