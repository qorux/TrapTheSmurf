package main.java.edu.chalmers.projecttemplate.model;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Smurf {

    //Kanske bör vara i Board/Application(projectTemplate)
    private boolean hasWon = false;

    //(NE,E,SE,SW,W,NW), alla möjliga directions smurfen kan ha?

    private Board board;
    private Node hexagonNode;
    private Hexagon hexagon;

    private ArrayList<String> deadDirections;

    private boolean isWandering = false;

    //private Map<String, Integer> directionsRouteValues = new HashMap<String, Integer>();

    public Smurf(Board Board) {
        this.board = Board;
        this.hexagonNode = board.getNode(60);
        this.hexagon = hexagonNode.getHexagon();
        this.deadDirections = new ArrayList<String>();
        hexagon.occupyTile();
    }


    public void moveSmurf() {
        hexagon.makeClickable();

        ArrayList<String> possibleDirections = findBlockedDirections();
        if (possibleDirections.size() == 0) {
            isWandering = true;
        }

        List<String> bestDirections;
        if (isWandering) {
            bestDirections = wanderSmurf();
        } else {
            Map<String, Integer> directionRouteValues = calculateRoute(possibleDirections);
            bestDirections = findShortestDirection(directionRouteValues);
        }

        moveInDirection(randomElement(bestDirections));
    }

    private ArrayList<String> wanderSmurf(){
        System.out.println("Smurf is wandering!");
        ArrayList<String> result = new ArrayList<String>();
        result.add("NW");
        result.add("NE");
        result.add("E");
        result.add("W");
        result.add("SW");
        result.add("SE");
        return result;
    }

    private String randomElement(List<String> Directions) {
        Random rand = new Random();
        String randomElement = Directions.get(rand.nextInt(Directions.size()));
        return randomElement;
    }

    public void moveInDirection(String Direction) {
        hexagonNode = hexagonNode.getNeighbors().get(Direction);
        hexagon = hexagonNode.getHexagon();
        System.out.println("Hexagonindex:" + hexagon.getIndex());
        hexagon.occupyTile();

       /*
       switch (Direction){
           case "NW":
               if (yPos % 2 == 0){ // even
                   xPos--;
                   yPos--;
               }
               else if (yPos % 2 == 1){ //odd
                   yPos--;
               }
           case "NE":
               if (yPos % 2 == 0){ // even
                   yPos--;
               }
               else if (yPos % 2 == 1){ //odd
                   yPos--;
                   xPos++;
               }
           case "E":
               xPos++;
               break;
           case "W":
               xPos--;
               break;
           case "SW":
               if (yPos % 2 == 0){ // even
                   yPos++;
                   xPos--;
               }
               else if (yPos % 2 == 1){ //odd
                   yPos++;
               }
           case "SE":
               if (yPos % 2 == 0){ // even
                   yPos++;
               }
               else if (yPos % 2 == 1){ //odd
                   yPos++;
                   xPos--;
               }
           default:
               break;

        */
    }

    public List<String> findShortestDirection(Map<String,Integer> directionsRouteValues) {
        List<Integer> sortedRouteValues = new ArrayList<Integer>();
        for (Map.Entry<String, Integer> entry : directionsRouteValues.entrySet()) {
            sortedRouteValues.add(entry.getValue());
        }
        Collections.sort(sortedRouteValues);

        int lowestValue = sortedRouteValues.get(0);
        List<String> key = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : directionsRouteValues.entrySet()) {
            if (entry.getValue() == lowestValue) {
                key.add(entry.getKey());
            }
        }
        return key;
    }


    public Map<String, Integer> calculateRoute(ArrayList<String> possibleDirections) {
        Map<String,Integer> directionsRouteValues = new HashMap<String,Integer>();
        for (String direction : possibleDirections) {
            directionsRouteValues.put(direction, findLength(direction));
        }
        return directionsRouteValues;
    }

    private ArrayList<String> findBlockedDirections() {
        ArrayList<String> result = new ArrayList<String>();
        result.add("NW");
        result.add("NE");
        result.add("E");
        result.add("W");
        result.add("SW");
        result.add("SE");
        if (deadDirections.size()>0){
            for(String direction:deadDirections){
                result.remove(direction);
            }
        }

        for (Map.Entry<String, Node> entry : hexagonNode.getNeighbors().entrySet()) {
            if (entry.getValue().getHexagon().getCurrentStateClass() == BlockedTile.class) {
                result.remove(entry.getKey());
            }
            if (isDeadEnd(entry.getValue())){
                result.remove(entry.getKey());
                deadDirections.add(entry.getKey());
                System.out.println("Deaddirection added:" + entry.getKey());
            }
        }

        /*
       if (board.getHexagonCoordinate(xPos,yPos-1).getCurrentStateClass() == BlockedTile.class){
           neighbours.remove("N");
       }
       if (board.getHexagonCoordinate(xPos+1,yPos).getCurrentStateClass() == BlockedTile.class){
           neighbours.remove("E");
       }
       if (board.getHexagonCoordinate(xPos-1,yPos).getCurrentStateClass() == BlockedTile.class){
           neighbours.remove("W");
       }
       if (board.getHexagonCoordinate(xPos,yPos+1).getCurrentStateClass() == BlockedTile.class){
           neighbours.remove("S");
       }

         */
        return result;
    }

    public boolean isDeadEnd(Node node){
        int counter = 0;
        for(Map.Entry<String,Node> neighborEntry:node.getNeighbors().entrySet()){
            if (neighborEntry.getValue().getHexagon().getCurrentStateClass() == BlockedTile.class){
                counter++;
            }
        }
        if (counter < 3){
            return false;
        }
        return true;
    }


    public int findLength(String direction) {
        boolean endTile = false;
        Node searchNode = hexagonNode;
        int length = 0;

        while (!endTile) {
            switch (direction) {
                case "NW":
                    searchNode = searchNode.getNeighbors().get("NW");
                    break;
                case "NE":
                    searchNode = searchNode.getNeighbors().get("NE");
                    break;
                case "W":
                    searchNode = searchNode.getNeighbors().get("W");
                    break;
                case "E":
                    searchNode = searchNode.getNeighbors().get("E");
                    break;
                case "SW":
                    searchNode = searchNode.getNeighbors().get("SW");
                    break;
                case "SE":
                    searchNode = searchNode.getNeighbors().get("SE");
                    break;
            }
            length++;
            endTile = foundEndTile(searchNode);
        }
        return length;
    }

    Boolean foundEndTile(Node searchNode) {
        int xPos = (searchNode.getHexagon().getIndex() % 11);
        int yPos = (searchNode.getHexagon().getIndex() / 11);
        if (xPos > 11 || yPos > 11 || xPos < 0 || yPos < 0) {
            System.out.println("Galet fel i foundendtile");
        }
        if (xPos == 10 || yPos == 10 || xPos == 0 || yPos == 0) {
            return true;
        }

        return false;
    }


    //Detta är väl säkert mot law of demeter, men tycker det ser bättre ut än i ProjectTemplate
    //fult, i know, kommer väl behövas skrivas om?
    //japp, onödig då vi gör detta i konstruktorn
    //måste fixa en upadteview först dock, men detta måste refractoras
    public void startPlaceSmurf() {
        hexagon.occupyTile();
    }

}
