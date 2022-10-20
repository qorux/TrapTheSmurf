package main.java.edu.chalmers.projecttemplate.model;


import java.util.HashMap;

import java.util.Map;

/**
 * Responsibility: Uses "Node"s to create a data structure to
 * describe the board of the game.
 * Uses: -
 * Used by: Smurf, Board
 */
public class Node {
    public Hexagon hexagon;

    private final Map<String, Node> neighbors;

    public Node(final Hexagon data) {
        this.neighbors = new HashMap<String,Node>();
        this.hexagon = data;
        //this.next = null;
    }

    public Hexagon getHexagon() {
        return hexagon;
    }

    public Map<String,Node> getNeighbors() {
        return neighbors;
    }


}