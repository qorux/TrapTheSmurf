package main.java.edu.chalmers.projecttemplate.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This class contains the logic for the board of the game
 */
public class Board {
    private List<List<Hexagon>> boardColumns;
    private List<Hexagon> boardRows;

    private PropertyChangeSupport support;

    /**
     * Sets up the board with 11 columns and 11 rows, adding up to 121 hexagons.
     */
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

    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public List<List<Hexagon>> getBoardSpaces() {
        return boardColumns;
    }

    /**
     * Randomizes how many tiles should be blocked and checks if the tiles are ok to block.
     * The number of tiles are randomized following normal distribution.
     * @return a list of indexes for the tiles that are to be blocked
     */
    public List<Boolean> randomizeBlockedTiles(){
        Random random = new Random();
        int totalBlockedTiles = Math.abs((int) Math.floor(random.nextGaussian() * 5 + 12));
        List<Boolean> shouldTileBeBlocked = new ArrayList<Boolean>(121);
        for(int i = 0; i < 121; i++) {
            if ((i<totalBlockedTiles) && (i != 60)){
                shouldTileBeBlocked.add(true);
            }
            else {
                shouldTileBeBlocked.add(false);
            }
        }
        return shouldTileBeBlocked;
    }

    /**
     * Shuffles the tiles that should be blocked
     * @param shouldTileBeBlocked List of tiles that should be blocked
     */
    public void shuffleBlockedTiles(List<Boolean> shouldTileBeBlocked) {
        Collections.shuffle(shouldTileBeBlocked);
        int index =0;
        for (Boolean tile:shouldTileBeBlocked) {
            if (tile) {
                blockTile(index);
            }
            index++;
        }
    }

    /**
     * Blocks a tile, with exception of the tile the smurf is on
     * @param index the index of the tile that should be blocked
     */
    public void blockTile(Integer index) {
        System.out.println("Tile "+index+" is blocked");
        if (index == 60) {  //smurftile
            ;
        }
        else {
            getHexagon(index).blockTile();
        }
    }

    /**
     * Converts an index to coordinates
     * @param index the index of the tile that we want to get the coordinates for
     * @return the coordinates for a tile
     */
    public Hexagon getHexagon(int index){
        int col = index / 11;
        int row = index % 11;

        return boardColumns.get(col).get(row);
    }

    public Hexagon getHexagonCoordinate(int xPos, int yPos){

        return boardColumns.get(yPos).get(xPos);
    }
}

