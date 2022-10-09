package main.java.edu.chalmers.projecttemplate.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    public Hexagon hexagon;
    private Node next;

    private Map<String, Node> neighbors;

    public Node(Hexagon data) {
        this.neighbors = new HashMap<String,Node>();
        this.hexagon = data;
        this.next = null;
    }

    public void setNextNode(Node node) {
        this.next = node;
    }

    public Hexagon getHexagon() {
        return hexagon;
    }

    public Node getNextNode() {
        return this.next;
    }

    public Map<String,Node> getNeighbors() {
        return neighbors;
    }


}