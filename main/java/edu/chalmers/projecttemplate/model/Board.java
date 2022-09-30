package main.java.edu.chalmers.projecttemplate.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import java.util.Random;

public class Board {
    private ArrayList <Hexagon> boardSpaces ;

    private PropertyChangeSupport support;

    public Board(){
        support = new PropertyChangeSupport(this);
        boardSpaces = new ArrayList<Hexagon>();
        for(int i=0;i<=121;i++){
            boardSpaces.add(new Hexagon(i, support));
        }

    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
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
            boardSpaces.get(index).getHexagonStateContext().setHexagonState(new BlockedTile());
        }
    }
}

