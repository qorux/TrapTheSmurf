package main.java.edu.chalmers.projecttemplate.model;


import java.util.HashMap;

import java.util.Map;

/**
 * Handles additional logic for the board of the game
 */
public class Node {
    public Hexagon hexagon;
    //private Node next;

    private final Map<String, Node> neighbors;

    public Node(final Hexagon data) {
        this.neighbors = new HashMap<String,Node>();
        this.hexagon = data;
        //this.next = null;
    }

   /* public void setNextNode(final Node node) {
        this.next = node;
    }
*/
    public Hexagon getHexagon() {
        return hexagon;
    }

   /* public Node getNextNode() {
        return this.next;
    }*/

    public Map<String,Node> getNeighbors() {
        return neighbors;
    }


}