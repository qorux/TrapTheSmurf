package main.java.edu.chalmers.projecttemplate.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Board {
    private List<List<Hexagon>> boardColumns;
    private List<Hexagon> boardRows;

    private PropertyChangeSupport support;

    public Board(){
        support = new PropertyChangeSupport(this);
        boardColumns = new ArrayList<>();
        for(int i=0;i<11;i++) {
            boardRows = new ArrayList<Hexagon>();
            for (int o = 0; o < 11; o++) {
                boardRows.add(new Hexagon((i * 11) + o, support));
            }
            boardColumns.add(boardRows);
        }
        System.out.println("Size of col" + boardColumns.size());

    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public List<List<Hexagon>> getBoardSpaces() {
        return boardColumns;
    }


    //genererar två olika nummer för antalet blockerade tiles tror jag, måste skrivas om
    //att vi skapar två olika instanser av random i två metoder borde inte vara rätt iaf
    public void randomizeBlockedTiles(){
        Random random = new Random();
        int totalBlockedTiles = Math.abs((int) Math.floor(random.nextGaussian() * 5 + 12));
        System.out.println("Number of blocked tiles this round: "+totalBlockedTiles);

        List<Boolean> shouldTileBeBlocked = new ArrayList<Boolean>(121);//sizeofboard variable

        for(int i = 0; i < 121; i++) {
            if (i<totalBlockedTiles){
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
        System.out.println("Index after for loop:" +
                index);
    }

    public void blockTile(Integer index) {
        System.out.println("Tile "+index+" is blocked");
        if (index == 60) {  //smurftile
            ;
        }
        else {
            getHexagon(index).getHexagonStateContext().setHexagonState(new BlockedTile());
        }
    }

    public Hexagon getHexagon(int index){
        int col = index / 11;
        int row = index % 11;

        return boardColumns.get(col).get(row);
    }

    public Hexagon getHexagonCoordinate(int xPos, int yPos){

        return boardColumns.get(yPos).get(xPos);
    }
}

