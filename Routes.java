package ICP_PROJECT;

public class Routes {

    private final String airlineCode;
    private final int airlineID;
    private final String sourceAirportCode;
    private int sourceAirportID;
    private String destinationAirportCode;
    private final  int destinationAirportId;
    private final String codeShare;
    private final int Stops;
    private final String equipment;

    /**
     *
     * @param airlineCode
     * @param airlineID
     * @param sourceAirportCode
     * @param sourceAirportID
     * @param destinationAirportCode
     * @param destinationAirportId
     * @param codeShare
     * @param Stops
     * @param equipment
     */

    public Routes  (String airlineCode,int airlineID, String sourceAirportCode, int sourceAirportID, String destinationAirportCode,int destinationAirportId,
                    String codeShare,int Stops,String equipment ) {
        this.airlineCode = airlineCode;
        this.airlineID = airlineID;
        this.sourceAirportCode = sourceAirportCode;
        this.sourceAirportID = sourceAirportID;
        this.destinationAirportCode = destinationAirportCode;
        this.destinationAirportId = destinationAirportId;
        this.codeShare = codeShare;
        this.Stops = Stops;
        this.equipment = equipment;

    }

    @java.lang.Override
    public java.lang.String toString(){
        return "Routes{ " +
                "airlinecode=" +   airlineCode +
                ", airlineId= '" + airlineID+ '\'' +
                ", sourceAirportCode='" + sourceAirportCode+ '\'' +
                ", sourceAirportId ='" + sourceAirportID +  '\'' +
                ",destinationAirportCode ='" + destinationAirportCode + '\'' +
                ",destinationAirportID ='" + destinationAirportId + '\'' +
                ", CodeShare=" + codeShare   + '\''+
                ",Stops ='" + Stops + '\'' +
                ", Equipment ='" + equipment + '\'' +
                '}';
    }

    public String getAirlineCode() {
        return airlineCode;
    }
    public int getAirlineID() {
        return airlineID;
    }
    public String getSourceAirportCode() {
        return sourceAirportCode;
    }
    public int getSourceAirportID() {
        return sourceAirportID;
    }
    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }
    public int getDestinationAirportId() {
        return destinationAirportId;
    }
    public String getCodeShare() {
        return codeShare;
    }
    public int getStops() {
        return Stops;
    }
    public String getEquipment() {
        return equipment;
    }
}
