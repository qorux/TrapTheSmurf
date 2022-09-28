package main.java.edu.chalmers.projecttemplate.model;

import java.util.ArrayList;
import main.java.edu.chalmers.projecttemplate.view.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private ArrayList <Hexagon> boardSpaces ;

    public Board(){
        boardSpaces = new ArrayList<Hexagon>();
        for(int i=0;i<=121;i++){
            boardSpaces.add(new Hexagon(i));
        }

    }

    public ArrayList<Hexagon> getBoardSpaces() {
        return boardSpaces;
    }

    public void randomizeBlockedTiles(){
        int numberOfBlockedTiles = ThreadLocalRandom.current().nextInt(11, 16);
        System.out.println("Number of blocked tiles this round: "+numberOfBlockedTiles);
        int i = 1;
        while (i <= numberOfBlockedTiles) {
            blockTile();
            i++;
        }
    }

    public void blockTile() {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(boardSpaces.size());
        System.out.println("Tile "+index+" is blocked");
        boardSpaces.get(index).setHexagonState(new BlockedTile(index));

    }




}

