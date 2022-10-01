package ICP_PROJECT;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Airports {

    /**
     * Instance Varaibles
     */

    private final int airportId;
    private final String airportName;
    private String City;
    private final String Country;
    private String iataCode;
    private String icaoCode;
    private final double Latitude;
    private final double Longitude;
    private  final double Altitude;
    private final double timezone;
    private final String DST;
    private final String TZ;
    private final String Type;
    private final String dataSource;

    /**
     *
     * @param  airportId
     * @param  airportName
     * @param  City
     * @param  Country
     * @param  iataCode
     * @param  icaoCode
     * @param  Latitude
     * @param  Longitude
     * @param  Altitude
     * @param  timezone
     * @param  DST
     * @param  TZ
     * @param  Type
     * @param  dataSource
     */
    public Airports(int airportId, String airportName,String City,String Country, String iataCode,String icaoCode,
                    double Latitude,double Longitude,double Altitude,double timezone,String DST,
                    String TZ,String Type,String dataSource){
        this.airportId = airportId;
        this.airportName = airportName;
        this.City =  City;
        this.Country = Country;
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
        this.Altitude = Altitude;
        this.timezone = timezone;
        this.DST = DST;
        this.TZ = TZ;
        this.Type = Type;
        this.dataSource = dataSource;

    }

    public Airports(){
        this.airportId = 0;
        this.airportName = "";
        this.City =  "";
        this.Country = "";
        this.iataCode = "";
        this.icaoCode = "";
        this.Latitude = 0.0;
        this.Longitude = 0.0;
        this.Altitude = 0.0;
        this.timezone = 0.0;
        this.DST = "";
        this.TZ = "";
        this.Type = "";
        this.dataSource = "";
    }

    @java.lang.Override
    public java.lang.String toString(){
        return "Airport{ " +
                "airportID=" +   airportId +
                ", airportName= '" + airportName + '\'' +
                ", City='" + City + '\'' +
                ", Country=" + Country + '\''+
                ", iataCode ='" + iataCode +  '\'' +
                ", icaoCode ='" + icaoCode + '\'' +
                ", Latitude=" + Latitude +
                ", Longitude=" + Longitude +
                ", Altitude=" +  Altitude +
                ", timezone=" + timezone +
                "'DST='" + DST + '\'' +
                ", TZ='" + TZ + '\'' +
                ", Type ='" + Type + '\'' +
                ", dataSource='" + dataSource + '\'' +
                '}';
    }

    /**
     * Mutator methods unused since the fields are final
     * Airline methods fields  Getter methods
     */

    public int getAirportId(){
        return airportId;
    }
    public String getAirportName(){
        return airportName;
    }
    public String getCity() {
        return City;
    }
    public String getCountry() {
        return Country;
    }
    public String getIataCode() {
        return iataCode;
    }
    public String getIcaoCode() {
        return icaoCode;
    }
    public double getLatitude() {
        return Latitude;
    }
    public double getLongitude() {
        return Longitude;
    }
    public double getAltitude() {
        return Altitude;
    }
    public double getTimezone() {
        return timezone;
    }
    public String getDST() {
        return DST;
    }
    public String getTZ() {
        return TZ;
    }
    public String getType() {
        return Type;
    }
    public String getDataSource() {
        return dataSource;
    }
}

