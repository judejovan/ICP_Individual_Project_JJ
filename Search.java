package ICP_PROJECT;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Objects;

public class Search {

    /**
     * the starting point and the  destination
     */
    private static String sourceAirportCode;
    private static String destinationAirportCode;

    public Search(String sourceAirportCode, String destinationAirportCode) {
        Search.sourceAirportCode = sourceAirportCode;
        Search.destinationAirportCode = destinationAirportCode;
    }

    @Override
    public String toString() {
        return "Source to destination: ";
    }

    /**
     * Goal test method checks location reached
     * and destination
     * * @param location
     */


    public static boolean goalTest(String location) {
        return false;
    }

    /**
     * method returns sequence of actions to reach goal
     */

    public ArrayList<ArrayList<String>> Actions() {
        return null;
    }

    public static class optimalDistance extends Search{
        private static HashMap<String, ArrayList<ArrayList<String>>> mMap;
    }

    /**
     * @param sourceAirportCode
     * @param destinationAirportCode
     * @param mMap
     */

    public optimalDistance(String sourceAirportCode, String destinationAirportCode, HashMap<String, ArrayList<ArrayList<String>>> mMap) {
        super(sourceAirportCode,destinationAirportCode);
        optimalDistance.mMap = mMap;
    }

    /**
     * @param Location
     * @param Destination
     * @return boolean
     */

    public static boolean goalTest(String Location, String Destination) {
        return Location.equals(Destination);
    }

    /**
     * @param sourceCode
     * @return Actions
     */

    public static ArrayList<ArrayList<String>> actions(String sourceCode) {
        HashMap<String, ArrayList<ArrayList<String>>> keyNeighbours = Routes.routeMap;
        //ArrayList for transition cost
        ArrayList<String> transitionCost = new ArrayList<>();
        // Successor states
        ArrayList<String> successorStates = new ArrayList<>();
        //returned sequence
        ArrayList<ArrayList<String>> sequence = new ArrayList<>();
        if (keyNeighbours.containsKey(sourceCode)) {
            //System.out.println("Checked: "+sourceCode);
            ArrayList<ArrayList<String>> values = keyNeighbours.get(sourceCode);
            //Looping  ArrayList and adding  transition cost and successor state to be returned
            for (ArrayList<String> neigbour : values) {
                transitionCost.add(neigbour.get(0));
                successorStates.add(neigbour.get(1));
            }
            sequence.add(transitionCost);
            sequence.add(successorStates);
            return sequence;
        }
        return sequence;
    }
}

        /**
         * Node class implements interface for access and comparison
         *
         */

        public static class Node implements  Comparable<Node> {
            private final String airportCode;
            private Node Parent;
            private double pathCost;

            /**
             * Constructor for node class
             */
            public Node(String airportCode, Node Parent, double pathCost) {
                this.airportCode = airportCode;
                this.Parent = Parent;
                this.pathCost = pathCost;
            }

            /**
             * Overloading constructor
             */

            public Node(String airportCode) {
                this.airportCode = airportCode;
            }

            public void solutionPath() {
                ArrayList<Node> result = new ArrayList<>();
                Node finalNode = this;
                while (finalNode != null) {
                    result.add(0, finalNode);
                    finalNode = finalNode.Parent;
                }
                writeToFile(result);
            }

            /***
             *   Method writes output to file
             * @param result
             */

            public void writeToFile(ArrayList<Node> result) {
                try {
                    PrintWriter out = new PrintWriter("Output.txt");
                    String reS = null;
                    int i = 0;
                    for (i = 1; i < result.size(); i++) {
                        reS = (i) + ". from " + result.get(i).Parent + " to " + result.get(i).airportCode;
                        out.write(reS + "\n");
                        System.out.println(reS);
                    }
                    out.write("Total Distance is: " + result.get(result.size() - 1).pathCost + "km\n");
                    out.write("Total No of flights: " + i);
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public int compareTo(Node o) {
                return Double.compare(this.pathCost, o.pathCost);
            }

            @Override
            public String toString() {
                return "" + airportCode;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return Objects.equals(airportCode, node.airportCode);
            }

            @Override
            public int hashCode() {
                return Objects.hash(airportCode); // Overiding the hashcode function

            }



        /**
         * UniformCostSearch (UCS)  To  compute optimal distance from location to destination
         * @param destinationCity
         * @param startCity
         * @return boolean
         */
        public static boolean UniformCostSearch(String startCity, String destinationCity){
            System.out.println("UCS from " + startCity + " to " + destinationCity);
            Node root = new Node(startCity);
            // Frontier
            PriorityQueue<Node> frontier = new PriorityQueue<>();
            frontier.add(root);
            HashSet<Node> explored = new HashSet<>();
            System.out.println("Initial frontier = " + frontier);
            System.out.println("Initial explored set = " + explored);
            while (frontier.size() > 0){
                Node poppedNode = frontier.remove();
                System.out.println("Checking!..");
                if (Search.optimalDistance.goalTest(poppedNode.airportCode, destinationCity)){
                    poppedNode.solutionPath();
                    System.out.println("Found a Solution: "+ poppedNode.airportCode);
                    return true;
                }
                explored.add(poppedNode);
//              System.out.println("Expanding:" + poppedNode);


                ArrayList<String> costs = Search.optimalDistance.actions(poppedNode.airportCode).get(0);
                ArrayList<String> successor = Search.optimalDistance.actions(poppedNode.airportCode).get(1);
                for (int i = 0; i < costs.size(); i++){
                    double oldPathCost = Double.parseDouble(costs.get(i))+poppedNode.pathCost;
                    Node child = new Node(successor.get(i),poppedNode, Double.parseDouble(costs.get(i))+poppedNode.pathCost);
                    if (! (explored.contains(child) && frontier.contains(child))){
                        frontier.add(child);
                    }
                    else {
                        if (child.pathCost < oldPathCost){
                            oldPathCost = child.pathCost;
                            child.Parent = poppedNode.Parent;
                            frontier.add(child);

                        }
                    }
                }

            }
            return false;

        }
    }
