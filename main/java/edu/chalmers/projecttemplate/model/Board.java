package main.java.edu.chalmers.projecttemplate.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;

public class Board {
    private List<List<Hexagon>> boardColumns;
    private List<Hexagon> boardRows;

    private List<List<Node>> boardNodesColumns;
    private List<Node> boardNodesRows;

    private PropertyChangeSupport support;

    public Board(){
        support = new PropertyChangeSupport(this);
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

    public List<List<Hexagon>> getBoardSpaces() {
        return boardColumns;
    }


    public List<Boolean> randomizeBlockedTiles(){
        Random random = new Random();
        int totalBlockedTiles = Math.abs((int) Math.floor(random.nextGaussian() * 5 + 12));
        System.out.println("Number of blocked tiles this round: "+totalBlockedTiles);
        List<Boolean> shouldTileBeBlocked = new ArrayList<Boolean>(121);
        for(int i = 0; i < 121; i++) {
            if ((i<totalBlockedTiles) && (i != 60)){
                shouldTileBeBlocked.add(true);
            }
            else {
                shouldTileBeBlocked.add(false);
            }
        }
        System.out.println(shouldTileBeBlocked);
        return shouldTileBeBlocked;
    }

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


    public void blockTile(Integer index) {
        System.out.println("Tile "+index+" is blocked");
        if (index == 60) {  //smurftile
            ;
        }
        else {
            getHexagon(index).blockTile();
        }
    }

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

