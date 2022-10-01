package main.java.edu.chalmers.projecttemplate.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
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

    public ArrayList<Hexagon> getBoardSpaces() {
        return boardSpaces;
    }


    //genererar två olika nummer för antalet blockerade tiles tror jag, måste skrivas om
    //att vi skapar två olika instanser av random i två metoder borde inte vara rätt iaf
    public void randomizeBlockedTiles(){
        Random random = new Random();
        int totalBlockedTiles = Math.abs((int) Math.floor(random.nextGaussian() * 5 + 12));
        System.out.println("Number of blocked tiles this round: "+totalBlockedTiles);

        List<Boolean> shouldTileBeBlocked = new ArrayList<Boolean>(121);//sizeofboard variable

        for(int i = 0; i < 121; i++) {
            if (i<=totalBlockedTiles){
                shouldTileBeBlocked.add(true);
            }
            else {
                shouldTileBeBlocked.add(false);
            }
        }
        Collections.shuffle(shouldTileBeBlocked);

        int index =0;
        for (Boolean tile:shouldTileBeBlocked){
            if (tile){
                blockTile(index);
            }
            index++;
        }
    }

    public void blockTile(Integer index) {
        System.out.println("Tile "+index+" is blocked");
        if (index == 60) {  //smurftile
            ;
        }
        else {
            boardSpaces.get(index).getHexagonStateContext().setHexagonState(new BlockedTile());
        }
    }
}

