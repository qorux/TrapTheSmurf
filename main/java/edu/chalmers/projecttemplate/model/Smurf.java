package main.java.edu.chalmers.projecttemplate.model;

import java.util.*;

public class Smurf {

    //Kanske bör vara i Board/Application(projectTemplate)
    private boolean hasWon = false;

    //(NE,E,SE,SW,W,NW), alla möjliga directions smurfen kan ha?
    ArrayList<String> possibleDirections;
    Map<String, Integer> directionsRouteValues = new HashMap();

    private int xPos = 5;
    private int yPos = 5;

    private Board board;
    private Hexagon hexagon;

   public Smurf(Board Board){
        this.board = Board;
        this.hexagon = board.getHexagon(60);
        this.possibleDirections = new ArrayList<>();
        resetPossibleDirections();

       for (String direction: possibleDirections) {
           directionsRouteValues.put(direction, 5);
       }
        hexagon.occupyTile();
    }
    private void resetPossibleDirections(){
       possibleDirections.clear();
        possibleDirections.add("N");
        possibleDirections.add("E");
        possibleDirections.add("W");
        possibleDirections.add("S");
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }


    public void moveSmurf(){
        resetPossibleDirections();
        directionsRouteValues.clear();
        hexagon.makeClickable();
        possibleDirections = findBlockedDirections(possibleDirections);
        System.out.println(possibleDirections);
        calculateRoute();
        List<String> shortestDirections = findShortestDirection();
        moveInDirection(randomElement(shortestDirections));


        hexagon = board.getHexagonCoordinate(xPos,yPos);
        System.out.println("Hexagonindex:" + hexagon.getIndex());
        hexagon.occupyTile();
    }

    private String randomElement(List<String> Directions){
        Random rand = new Random();
        String randomElement = Directions.get(rand.nextInt(Directions.size()));
        return randomElement;
    }


    public void moveInDirection(String Direction){
       System.out.println(Direction);
       switch (Direction){
           case "N":
               yPos--;
               break;
           case "E":
               xPos++;
               break;
           case "W":
               xPos--;
               break;
           case "S":
               yPos++;
               break;
           default:
               break;
       }
    }

    public List<String> findShortestDirection(){
        List<Integer> sortedRouteValues = new ArrayList<Integer>();
        for (Map.Entry<String, Integer> entry : directionsRouteValues.entrySet()) {
            sortedRouteValues.add(entry.getValue());
        }
        Collections.sort(sortedRouteValues);

        int lowestValue = sortedRouteValues.get(0);
        List<String> key = new ArrayList<>();

        for(Map.Entry<String, Integer> entry: directionsRouteValues.entrySet()) {
            if(entry.getValue() == lowestValue) {
                key.add(entry.getKey());
                System.out.println("The key for value " + lowestValue + " is " + entry.getKey());
            }
        }
        System.out.println("Shortest path/paths: " + lowestValue + key);
        return key;
    }

//Detta är väl säkert mot law of demeter, men tycker det ser bättre ut än i ProjectTemplate
    //fult, i know, kommer väl behövas skrivas om?
    //japp, onödig då vi gör detta i konstruktorn
    //måste fixa en upadteview först dock, men detta måste refractoras
    public void startPlaceSmurf(){
        hexagon.occupyTile();
    }

    public void calculateRoute(){
        for(String direction: possibleDirections){
            directionsRouteValues.put(direction, findLength(direction));
        }
        System.out.println(directionsRouteValues.entrySet());

    }

    private ArrayList<String> findBlockedDirections(ArrayList<String> PossibleDirections){    //command query?????
       // NEWS
        System.out.println(PossibleDirections);
       if (board.getHexagonCoordinate(xPos,yPos-1).getCurrentStateClass() == BlockedTile.class){
           PossibleDirections.remove("N");
       }
       if (board.getHexagonCoordinate(xPos+1,yPos).getCurrentStateClass() == BlockedTile.class){
           PossibleDirections.remove("E");
       }
       if (board.getHexagonCoordinate(xPos-1,yPos).getCurrentStateClass() == BlockedTile.class){
           PossibleDirections.remove("W");
       }
       if (board.getHexagonCoordinate(xPos,yPos+1).getCurrentStateClass() == BlockedTile.class){
           PossibleDirections.remove("S");
       }
       return PossibleDirections;
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
                    searchY--;
                    break;
                case "S":
                    searchY++;
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
        if (xPos>11 || yPos>11 || xPos< 0 ||yPos <0){
            System.out.println("Galet fel i foundendtile");
        }
        if (xPos==10 || yPos==10 || xPos== 0 ||yPos ==0){
            return true;
        }

        return false;
    }


}
