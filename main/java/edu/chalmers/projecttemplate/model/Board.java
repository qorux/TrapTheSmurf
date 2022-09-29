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
        Random random = new Random();
        int numberOfBlockedTiles = Math.abs((int) Math.floor(random.nextGaussian() * 5 + 12));
        System.out.println("Number of blocked tiles this round: "+numberOfBlockedTiles);
        for(int i=1;i<=numberOfBlockedTiles;i++) { //for each??
            blockTile();
        }
    }

    //Blockerar just nu smurfen ;(
    public void blockTile() {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(boardSpaces.size());
        System.out.println("Tile "+index+" is blocked");
        if (index == 58) {
           blockTile(); } //makes the smurfs start tile unblockable
        else {
            boardSpaces.get(index).setHexagonState(new BlockedTile(index));
        }
    }




}

