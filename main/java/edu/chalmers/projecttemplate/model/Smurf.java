package main.java.edu.chalmers.projecttemplate.model;

import main.java.edu.chalmers.projecttemplate.view.myFirstForm;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Smurf {

    //Kanske bör vara i Board/Application(projectTemplate)
    private boolean hasWon = false;

    //(NE,E,SE,SW,W,NW), alla möjliga directions smurfen kan ha?
    final List<String> directions = Arrays.asList("N","E","W","S");
    //Kanske bör ändras, med avseende på hur hexagonerna är implementerade
    //Något sätt att indikera vilken knapp/hexagon man står på! :)
    private int xPos = 6;
    private int yPos = 6;

    private Hexagon hexagon;

    public Smurf(Hexagon Hexagon){
        this.hexagon = Hexagon;
        hexagon.setHexagonState(new OccupiedTile());
        hexagon.occupyTile();
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void moveSmurf(){

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
            //System.out.print(searchX);
            //System.out.println(searchY);
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
    public void jump(){

    }




}
