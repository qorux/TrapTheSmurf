package main.java.edu.chalmers.projecttemplate.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Smurf {

    private boolean hasWon = false;

    final List<String> directions = Arrays.asList("N","E","W","S");

    private int xPos = 6;
    private int yPos = 6;

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
