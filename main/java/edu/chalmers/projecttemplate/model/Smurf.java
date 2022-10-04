package main.java.edu.chalmers.projecttemplate.model;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Smurf {

    //Kanske bör vara i Board/Application(projectTemplate)
    private boolean hasWon = false;

    //(NE,E,SE,SW,W,NW), alla möjliga directions smurfen kan ha?
    final List<String> directions = Arrays.asList("N","E","W","S");

    private int xPos = 5;
    private int yPos = 5;

    private Board board;
    private Hexagon hexagon;

   public Smurf(Board Board){
        this.board = Board;
        this.hexagon = board.getHexagon(60);

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
        ArrayList<Integer> routes = calculateRoute();
        System.out.println(routes);
        Collections.sort(routes);
        moveNorth();     //ej klar
        hexagon = board.getHexagonCoordinate(xPos,yPos);
        hexagon.occupyTile();
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

    public ArrayList<Integer> calculateRoute(){
        ArrayList<Integer> routeLengths = new ArrayList<Integer>();
        for(String direction:directions){
            routeLengths.add(findLength(direction));
        }
        System.out.println(routeLengths);
        return routeLengths;
    }

    public int findLength(String direction){
        boolean endTile = false;
        int searchX= xPos;
        int searchY = yPos;
        int length =0;

        System.out.println(direction);
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
