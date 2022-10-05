package main.java.edu.chalmers.projecttemplate.model;

import java.util.*;

public class Smurf {

    //Kanske bör vara i Board/Application(projectTemplate)
    private boolean hasWon = false;

    //(NE,E,SE,SW,W,NW), alla möjliga directions smurfen kan ha?
    final List<String> directions = Arrays.asList("N","E","W","S");
    Map<String, Integer> directionsRouteValues = new HashMap();

    private int xPos = 5;
    private int yPos = 5;

    private Board board;
    private Hexagon hexagon;

   public Smurf(Board Board){
        this.board = Board;
        this.hexagon = board.getHexagon(60);

       for (String direction:directions) {
           directionsRouteValues.put(direction, 5);
       }
        hexagon.occupyTile();
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }


    public void moveSmurf(){
        hexagon.makeClickable();
        calculateRoute();
        String direction = findShortestDirection();
        moveInDirection(direction);
        hexagon = board.getHexagonCoordinate(xPos,yPos);
        hexagon.occupyTile();
    }


    public void moveInDirection(String Direction){
       switch (Direction){
           case "N":
               yPos--;
           case "E":
               xPos++;
           case "W":
               xPos--;
           case "S":
               yPos++;
       }
    }
    public String findShortestDirection(){
        List<Integer> sortedRouteValues = new ArrayList<Integer>();
        List<String> sortedRouteKeys = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : directionsRouteValues.entrySet()) {
            sortedRouteValues.add(entry.getValue());
        }
        Collections.sort(sortedRouteValues);
        int value = sortedRouteValues.get(0);
        String key = "";
        for(Map.Entry<String, Integer> entry: directionsRouteValues.entrySet()) {

            // if give value is equal to value from entry
            // print the corresponding key
            if(entry.getValue() == value) {
                key = entry.getKey();
                System.out.println("The key for value " + value + " is " + entry.getKey());
                break;
            }
        }
        System.out.println("Shortest path: " + value + key);
        return key;
    }

    private void moveNorth(){
       yPos--;
    }

//Detta är väl säkert mot law of demeter, men tycker det ser bättre ut än i ProjectTemplate
    //fult, i know, kommer väl behövas skrivas om?
    //japp, onödig då vi gör detta i konstruktorn
    //måste fixa en upadteview först dock, men detta måste refractoras
    public void startPlaceSmurf(){
        hexagon.occupyTile();
    }

    public void calculateRoute(){
        for(String direction:directions){
            directionsRouteValues.put(direction, findLength(direction));
        }
        System.out.println(directionsRouteValues.entrySet());
    }

    public Map<String, Integer> getDirectionsRouteValues() {
        return directionsRouteValues;
    }

    public int findLength(String direction){
        boolean endTile = false;
        int searchX= xPos;
        int searchY = yPos;
        int length =0;

        while(!endTile){
            switch (direction){
                case "N":
                    searchY++;
                    break;
                case "S":
                    searchY--;
                    break;
                case "E":
                    searchX++;
                    break;
                case "W":
                    searchX--;
                    break;
            }
            length++;
            endTile = foundEndTile(searchX,searchY);
        }
        return length;
    }

    Boolean foundEndTile(int xPos,int yPos){
        if (xPos>=11 || yPos>=11 || xPos<= 1 ||yPos <=1){
            return true;
        }
        return false;
    }


}
