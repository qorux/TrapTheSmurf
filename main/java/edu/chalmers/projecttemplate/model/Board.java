package main.java.edu.chalmers.projecttemplate.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;
import main.java.edu.chalmers.projecttemplate.model.GameHandler.Difficulty;

/**
 * This class contains the logic for the board of the game.
 * This includes setting up the board in rows and columns,
 * and randomizing the blocked tiles the board is initiated with.
 */
public class Board {
    private final List<List<Hexagon>> boardColumns;

    private final List<List<Node>> boardNodesColumns;


    private final PropertyChangeSupport support;


    /**
     * Sets up the board with 11 columns and 11 rows, adding up to 121 hexagons.
     */
    public Board(final PropertyChangeSupport support){
        this.support=support;
        boardColumns = new ArrayList<>();
        boardNodesColumns = new ArrayList<>();

        for(int i=0;i<11;i++) {
            final List<Hexagon> boardRows = new ArrayList<Hexagon>();
            final List<Node> boardNodesRows = new ArrayList<Node>();
            for (int o = 0; o < 11; o++) {
                boardRows.add(new Hexagon((i * 11) + o, support));
                boardNodesRows.add(new Node(boardRows.get(o)));
            }
            boardColumns.add(boardRows);
            boardNodesColumns.add(boardNodesRows);
        }
        buildNeighboursList();
    }



    private void buildNeighboursList(){
        for (int r = 0; r <= 10; r++) {
            for (int c = 0; c <= 10; c++) {
                final Node node = boardNodesColumns.get(r).get(c);
                final Map<String, Node> neighbors = node.getNeighbors();
                if (r > 0) {     // has NorthWest
                    if ((c == 0) && (r%2 == 1)){    //udda c0
                        neighbors.put("NW", boardNodesColumns.get(r-1).get(c));
                    }
                    else if ((c == 0) && (r%2 == 0) ){  //jämn c0

                    }
                    else if ((c>0) && (r%2 == 1)){ //udda rad
                        neighbors.put("NW", boardNodesColumns.get(r-1).get(c));
                    }
                    else if ((c>0) && (r%2 == 0)){ //jämn rad
                        neighbors.put("NW", boardNodesColumns.get(r-1).get(c-1));
                    }
                }
                if (r > 0) {     // has NorthEast
                    if ((c == 10) && (r%2 == 1)){    //ojämn c11

                    }
                    else if ((c == 10) && (r%2 == 0)) {  //jämn c11
                        neighbors.put("NE", boardNodesColumns.get(r-1).get(c));
                    }
                    else if ((c<10) && (r%2 == 1)){ // udda rad
                        neighbors.put("NE", boardNodesColumns.get(r-1).get(c+1));
                    }
                    else if ((c<10) && (r%2 == 0)){ //jämn rad
                        neighbors.put("NE", boardNodesColumns.get(r-1).get(c));
                    }
                }
                if (c > 0) {     // has west
                    neighbors.put("W", boardNodesColumns.get(r).get(c-1));
                }
                if (c < 10) { // has east
                    neighbors.put("E", boardNodesColumns.get(r).get(c+1));
                }
                if (r < 10) {     // has SouthWest
                    if ((c == 0) && (r%2 == 1)){    //udda c0
                        neighbors.put("SW", boardNodesColumns.get(r+1).get(c));
                    }
                    else if ((c == 0) && (r%2 == 0)) {  //jämn c0

                    }
                    else if ((c>0) && (r%2 == 1)){ //udda rad
                        neighbors.put("SW", boardNodesColumns.get(r+1).get(c));
                    }
                    else if ((c>0) && (r%2 == 0)){ //jämn rad
                        neighbors.put("SW", boardNodesColumns.get(r+1).get(c-1));
                    }
                }
                if (r < 10) {     // has SouthEast
                    if ((c == 10) && (r%2 == 1)){    //udda c11

                    }
                    else if ((c == 10) && (r%2 == 0)) {  //jämn c11
                        neighbors.put("SE", boardNodesColumns.get(r+1).get(c));
                    }
                    else if ((c<10) && (r%2 == 1)){ //udda rad
                        neighbors.put("SE", boardNodesColumns.get(r+1).get(c+1));
                    }
                    else if ((c<10) && (r%2 == 0)){ //jämn rad
                        neighbors.put("SE", boardNodesColumns.get(r+1).get(c));
                    }
                }
            }
        }
    }

    /**
     * Randomizes how many tiles should be blocked based on the difficulty the player wants
     * If no difficulty is selected, the number of blocked tiles are randomized following normal
     * distribution.
     * @param difficulty the difficulty the game should have
     * @return how many tiles that should be blocked
     */
    public int difficultyBlockedTiles(final Difficulty difficulty) {
        final Random random = new Random();
        int totalBlockedTiles;
        if (Objects.equals(difficulty, Difficulty.EASY)) {
            totalBlockedTiles = random.nextInt(15, 19 + 1);
        }
        else if (Objects.equals(difficulty, Difficulty.HARD)) {
            totalBlockedTiles = random.nextInt(2, 6 + 1);
        }
        else if (Objects.equals(difficulty, Difficulty.MEDIUM)) {
            totalBlockedTiles = random.nextInt(7, 12 + 1);
        }
        else {
            totalBlockedTiles = Math.abs((int) Math.floor(random.nextGaussian() * 5 + 12));
        }
       return totalBlockedTiles;
    }


    private List<Boolean> generateBlockedTilesList(final int tilesToBeBlocked){
        final List<Boolean> okToBlock = new ArrayList<Boolean>(121);
        for(int i = 0; i < 121; i++) {
            if ((i<tilesToBeBlocked) && (i != 60)){
                okToBlock.add(true);
            }
            else {
                okToBlock.add(false);
            }
        }
        Collections.shuffle(okToBlock);
        return okToBlock;
    }

    /**
     * Shuffles the tiles that should be blocked
     */
    public void shuffleBlockedTiles(final Difficulty difficulty) { //Byta namn på denna metod kanske?
        final int tilesToBeBlocked = difficultyBlockedTiles(difficulty);
        final List<Boolean> toBeBlocked = generateBlockedTilesList(tilesToBeBlocked);
        int index = 0;
        for (final Boolean tile:toBeBlocked) {
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
    public void blockTile(final Integer index) {
        if (index == 60) {

        }
        else {
            getHexagon(index).setHexagonState(Hexagon.State.BLOCKED);
        }
    }


    public void addPropertyChangeListener(final PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(final PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    /**
     * Converts an index to coordinates
     * @param index the index of the tile that we want to get the coordinates for
     * @return the coordinates for a tile
     */
    public Hexagon getHexagon(final int index){
        final int col = index / 11;
        final int row = index % 11;

        return boardColumns.get(col).get(row);
    }



    public Node getNode(final int index){
        final int col = index / 11;
        final int row = index % 11;

        return boardNodesColumns.get(col).get(row);
    }

    public Hexagon getHexagonCoordinate(final int xPos,final int yPos){

        return boardColumns.get(yPos).get(xPos);
    }

    public List<List<Hexagon>> getBoardSpaces() {
        return boardColumns;
    }

    public List<List<Node>> getBoardNodesColumns() {
        return boardNodesColumns;
    }

}

