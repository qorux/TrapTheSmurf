package main.java.edu.chalmers.projecttemplate.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;
import main.java.edu.chalmers.projecttemplate.model.GameHandler.Difficulty;

/**
 * This class contains the logic for the board of the game
 */
public class Board {
    private final List<List<Hexagon>> boardColumns;
    private List<Hexagon> boardRows;

    private final List<List<Node>> boardNodesColumns;
    private List<Node> boardNodesRows;

    private final PropertyChangeSupport support;


    /**
     * Sets up the board with 11 columns and 11 rows, adding up to 121 hexagons.
     */
    public Board(PropertyChangeSupport support){
        this.support=support;
        boardColumns = new ArrayList<>();
        boardNodesColumns = new ArrayList<>();

        for(int i=0;i<11;i++) {
            boardRows = new ArrayList<Hexagon>();
            boardNodesRows = new ArrayList<Node>();
            for (int o = 0; o < 11; o++) {
                boardRows.add(new Hexagon((i * 11) + o, support));
                boardNodesRows.add(new Node(boardRows.get(o)));
            }
            boardColumns.add(boardRows);
            boardNodesColumns.add(boardNodesRows);
        }
        buildNeighboursList();
    }

    public List<List<Node>> getBoardNodesColumns() {
        return boardNodesColumns;
    }

    private void buildNeighboursList(){
        for (int r = 0; r <= 10; r++) {
            for (int c = 0; c <= 10; c++) {
                Node n = boardNodesColumns.get(r).get(c);
                Map<String, Node> neighbors = n.getNeighbors();
                if (r > 0) {     // has NorthWest
                    if ((c == 0) && (r%2 == 1)){    //udda c0
                        neighbors.put("NW", boardNodesColumns.get(r-1).get(c));
                    }
                    else if ((c == 0) && (r%2 == 0) ){  //jämn c0
                        ;
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
                        ;
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
                        ;
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
                        ;
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

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public List<List<Hexagon>> getBoardSpaces() {
        return boardColumns;
    }


    /**
     * Randomizes how many tiles should be blocked based on the difficulty the player wants
     * If no difficulty is selected, the number of blocked tiles are randomized following normal distribution.
     * @param difficulty the difficulty the game should have
     * @return how many tiles that should be blocked
     */
    public int difficultyBlockedTiles(Difficulty difficulty) {
        Random random = new Random();
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

    /**
     * Checks if the tiles are ok to block
     * @return a list of indexes for the tiles that are to be blocked
     */
    private List<Boolean> generateBlockedTilesList(int tilesToBeBlocked){
        List<Boolean> shouldTileBeBlocked = new ArrayList<Boolean>(121);
        for(int i = 0; i < 121; i++) {
            if ((i<tilesToBeBlocked) && (i != 60)){
                shouldTileBeBlocked.add(true);
            }
            else {
                shouldTileBeBlocked.add(false);
            }
        }
        Collections.shuffle(shouldTileBeBlocked);
        return shouldTileBeBlocked;
    }

    /**
     * Shuffles the tiles that should be blocked
     */
    public void shuffleBlockedTiles(Difficulty difficulty) { //Byta namn på denna metod kanske?
        int tilesToBeBlocked = difficultyBlockedTiles(difficulty);
        List<Boolean> shouldTileBeBlocked = generateBlockedTilesList(tilesToBeBlocked);
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
        if (index == 60) {
            getHexagon(index).setHexagonState(Hexagon.State.OCCUPIED);
        }
        else {
            getHexagon(index).setHexagonState(Hexagon.State.BLOCKED);
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

    public Node getNode(int index){
        int col = index / 11;
        int row = index % 11;

        return boardNodesColumns.get(col).get(row);
    }

    public Hexagon getHexagonCoordinate(int xPos, int yPos){

        return boardColumns.get(yPos).get(xPos);
    }


}

