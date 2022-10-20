package main.java.model;


import java.util.HashMap;

import java.util.Map;

public class Node {
    public Hexagon hexagon;
    private Node next;

    private final Map<String, Node> neighbors;

    public Node(final Hexagon data) {
        this.neighbors = new HashMap<String,Node>();
        this.hexagon = data;
        this.next = null;
    }

    public void setNextNode(final Node node) {
        this.next = node;
    }

    public Hexagon getHexagon() {
        return hexagon;
    }

    public Map<String,Node> getNeighbors() {
        return neighbors;
    }


}