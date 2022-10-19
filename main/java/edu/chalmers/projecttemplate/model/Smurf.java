package main.java.edu.chalmers.projecttemplate.model;

import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Smurf {

    //Kanske bör vara i Board/Application(projectTemplate)


    //(NE,E,SE,SW,W,NW), alla möjliga directions smurfen kan ha?

    private final Board board;
    private Node hexagonNode;
    private Hexagon hexagon;

    private final List<String> deadDirections;

    private boolean isWandering;

    //private Map<String, Integer> directionsRouteValues = new HashMap<String, Integer>();

    public Smurf(Board board) {
        this.board = board;
        this.hexagonNode = this.board.getNode(60);
        this.hexagon = hexagonNode.getHexagon();
        hexagon.setHexagonState(Hexagon.State.OCCUPIED);
        this.deadDirections = new ArrayList<String>();
    }


    public void moveSmurf() {
        List<String> possibleDirections = findBlockedDirections();
        List<String> deadDirections = findDeadDirections(possibleDirections);

        if (deadDirections.isEmpty()){
            isWandering= true;
        }
        List<String> bestDirections;
        if (isWandering) {
            moveInDirection(randomElement(possibleDirections));
        } else {
            Map<String, Integer> directionRouteValues = calculateRoute(findDeadDirections(possibleDirections));
            bestDirections = findShortestDirection(directionRouteValues);
            moveInDirection(randomElement(bestDirections));
        }


    }


    private String randomElement(List<String> directions) {
        Random rand = new Random();
        return directions.get(rand.nextInt(directions.size()));
    }

    private void moveInDirection(String direction) {
        hexagon.setHexagonState(Hexagon.State.FREE);
        hexagonNode = hexagonNode.getNeighbors().get(direction);
        hexagon = hexagonNode.getHexagon();
        hexagon.setHexagonState(Hexagon.State.OCCUPIED);
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

    private List<String> findShortestDirection(Map<String,Integer> directionsRouteValues) {
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


    private Map<String, Integer> calculateRoute(List<String> result) {
        if (!deadDirections.isEmpty()){
            for(String direction:deadDirections){
                result.remove(direction);
            }
        }

        Map<String,Integer> directionsRouteValues = new HashMap<String,Integer>();
        for (String direction : result) {
            directionsRouteValues.put(direction, findLength(direction));
        }
        return directionsRouteValues;
    }

    private List<String> findBlockedDirections() {
        List<String> result = new ArrayList<String>();

        result.add("NW");
        result.add("NE");
        result.add("E");
        result.add("W");
        result.add("SW");
        result.add("SE");

        for (Map.Entry<String, Node> entry : hexagonNode.getNeighbors().entrySet()) {
            if (entry.getValue().getHexagon().getCurrentState() == Hexagon.State.BLOCKED) {
                result.remove(entry.getKey());
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

    private List<String> findDeadDirections(List<String> possibleDirections){
        List<String> result= new ArrayList<String>();
        for (String direction:possibleDirections){
            result.add(direction);
        }
        for (Map.Entry<String, Node> entry : hexagonNode.getNeighbors().entrySet()) {
            if (isDeadEnd(entry.getValue())) {
                if (!deadDirections.contains(entry.getKey())) {
                    deadDirections.add(entry.getKey());
                }
            }
        }
        for(String direction:deadDirections){
            result.remove(direction);
        }

        return result;
    }

    private boolean isDeadEnd(Node node){
        int counter = 0;
        for(Map.Entry<String,Node> neighborEntry:node.getNeighbors().entrySet()){
            if (neighborEntry.getValue().getHexagon().getCurrentState() == Hexagon.State.BLOCKED){
                counter++;
            }
        }
        return counter >= 3;
    }


    private int findLength(String direction) {
        boolean endTile = false;
        Node searchNode = hexagonNode;
        int length = 0;

        while (!endTile) {
            switch (direction) {
                case "NW" -> searchNode = searchNode.getNeighbors().get("NW");
                case "NE" -> searchNode = searchNode.getNeighbors().get("NE");
                case "W" -> searchNode = searchNode.getNeighbors().get("W");
                case "E" -> searchNode = searchNode.getNeighbors().get("E");
                case "SW" -> searchNode = searchNode.getNeighbors().get("SW");
                case "SE" -> searchNode = searchNode.getNeighbors().get("SE");
            }
            length++;
            endTile = foundEndTile(searchNode);
        }
        return length;
    }

    private Boolean foundEndTile(Node searchNode) {
        int xPos = (searchNode.getHexagon().getIndex() % 11);
        int yPos = (searchNode.getHexagon().getIndex() / 11);
        if (xPos > 11 || yPos > 11 || xPos < 0 || yPos < 0) {
        }
        return xPos == 10 || yPos == 10 || xPos == 0 || yPos == 0;
    }

    public boolean checkIfWon() {
        return checkFreeNeighbors().isEmpty();
    }

    public boolean checkIfLost(){
        return hexagonNode.getNeighbors().entrySet().size() < 6;
    }

    private List<Hexagon> checkFreeNeighbors() {
        List<Hexagon> freeNeighbors = new ArrayList<>();
        List<Hexagon> tilesToCheck = new ArrayList<>();

        tilesToCheck.add(hexagonNode.getNeighbors().get("NW").getHexagon());
        tilesToCheck.add(hexagonNode.getNeighbors().get("NE").getHexagon());
        tilesToCheck.add(hexagonNode.getNeighbors().get("W").getHexagon());
        tilesToCheck.add(hexagonNode.getNeighbors().get("E").getHexagon());
        tilesToCheck.add(hexagonNode.getNeighbors().get("SE").getHexagon());
        tilesToCheck.add(hexagonNode.getNeighbors().get("SW").getHexagon());

        for (Hexagon hexagon : tilesToCheck) {
            if (Hexagon.State.FREE.equals(hexagon.getCurrentState())) {
                freeNeighbors.add(hexagon);
            }
    }
        return freeNeighbors;
    }


    public Hexagon getSmurfHexagon() {
        return hexagon;
    }
}
