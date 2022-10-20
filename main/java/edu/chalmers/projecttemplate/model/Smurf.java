package main.java.edu.chalmers.projecttemplate.model;

import java.util.*;

/**
 * Responsibility: the logic for the smurf, such as how it
 * determines where to go and how it's allowed to move
 * Uses: Board, Hexagon, Node
 * Used by: Game
 */
public class Smurf {
        private Node hexagonNode;
    private Hexagon hexagon;

    private final List<String> deadDirections;

    private boolean isWandering;

    public Smurf(final Board board) {
        this.hexagonNode = board.getNode(60);
        this.hexagon = hexagonNode.getHexagon();
        this.deadDirections = new ArrayList<String>();
    }

    /**
     * Moves the smurf. The smurf can have 6 possible directions: (NE,E,SE,SW,W,NW)
     * The smurf will search for the shortest possible direction to the edge of the board.
     * If one direction is blocked, it will not search for ways to the edge in that way anymore.
     * When all directions have been blocked, it will randomize where to go.
     */
    public void moveSmurf() {
        final List<String> possibleDirections = findBlockedDirections();
        final List<String> deadDirections = findDeadDirections(possibleDirections);

        if (deadDirections.isEmpty()){
            isWandering= true;
        }
        List<String> bestDirections;
        if (isWandering) {
            moveInDirection(randomElement(possibleDirections));
        } else {
            final Map<String, Integer> directionRouteValues = calculateRoute(findDeadDirections(possibleDirections));
            bestDirections = findShortestDirection(directionRouteValues);
            moveInDirection(randomElement(bestDirections));
        }


    }


    private String randomElement(final List<String> directions) {
        final Random rand = new Random();
        return directions.get(rand.nextInt(directions.size()));
    }

    private void moveInDirection(final String direction) {
        hexagon.setHexagonState(Hexagon.State.FREE);
        hexagonNode = hexagonNode.getNeighbors().get(direction);
        hexagon = hexagonNode.getHexagon();
        hexagon.setHexagonState(Hexagon.State.OCCUPIED);
    }

    private List<String> findShortestDirection(final Map<String,Integer> directionsRouteValues) {
        final List<Integer> sortedRouteValues = new ArrayList<Integer>();
        for (final Map.Entry<String, Integer> entry : directionsRouteValues.entrySet()) {
            sortedRouteValues.add(entry.getValue());
        }
        Collections.sort(sortedRouteValues);

        final int lowestValue = sortedRouteValues.get(0);
        final List<String> key = new ArrayList<>();

        for (final Map.Entry<String, Integer> entry : directionsRouteValues.entrySet()) {
            if (entry.getValue() == lowestValue) {
                key.add(entry.getKey());
            }
        }
        return key;
    }


    private Map<String, Integer> calculateRoute(final List<String> result) {
        if (!deadDirections.isEmpty()){
            for(final String direction:deadDirections){
                result.remove(direction);
            }
        }

        final Map<String,Integer> directionsRouteValues = new HashMap<String,Integer>();
        for (final String direction : result) {
            directionsRouteValues.put(direction, findLength(direction));
        }
        return directionsRouteValues;
    }

    private List<String> findBlockedDirections() {
        final List<String> result = new ArrayList<String>();

        result.add("NW");
        result.add("NE");
        result.add("E");
        result.add("W");
        result.add("SW");
        result.add("SE");

        for (final Map.Entry<String, Node> entry : hexagonNode.getNeighbors().entrySet()) {
            if (entry.getValue().getHexagon().getCurrentState() == Hexagon.State.BLOCKED) {
                result.remove(entry.getKey());
            }
        }
        return result;
    }

    private List<String> findDeadDirections(final List<String> possibleDirections){
        final List<String> result= new ArrayList<String>();
        for (final String direction:possibleDirections){
            result.add(direction);
        }
        for (final Map.Entry<String, Node> entry : hexagonNode.getNeighbors().entrySet()) {
            if (isDeadEnd(entry.getValue())) {
                if (!deadDirections.contains(entry.getKey())) {
                    deadDirections.add(entry.getKey());
                }
            }
        }
        for(final String direction:deadDirections){
            result.remove(direction);
        }

        return result;
    }

    private boolean isDeadEnd(final Node node){
        int counter = 0;
        for(final Map.Entry<String,Node> neighborEntry:node.getNeighbors().entrySet()){
            if (neighborEntry.getValue().getHexagon().getCurrentState() == Hexagon.State.BLOCKED){
                counter++;
            }
        }
        return counter >= 3;
    }


    private int findLength(final String direction) {
        boolean endTile = false;
        Node searchNode = hexagonNode;
        int length = 0;

        while (!endTile) {
            switch (direction) {
                case "NW" -> searchNode = searchNode.getNeighbors().get("NW");
                case "NE" -> searchNode = searchNode.getNeighbors().get("NE");
                case "W" -> searchNode = searchNode.getNeighbors().get("W");
                case "E" -> searchNode = searchNode.getNeighbors().get("E");
                case "SW" -> searchNode = searchNode.getNeighbors().get("SW");
                case "SE" -> searchNode = searchNode.getNeighbors().get("SE");
            }
            length++;
            endTile = foundEndTile(searchNode);
        }
        return length;
    }

    private Boolean foundEndTile(final Node searchNode) {
        final int xPos = (searchNode.getHexagon().getIndex() % 11);
        final int yPos = (searchNode.getHexagon().getIndex() / 11);
        if (xPos > 11 || yPos > 11 || xPos < 0 || yPos < 0) {
        }
        return xPos == 10 || yPos == 10 || xPos == 0 || yPos == 0;
    }

    /**
     * checks if the game is won by checking if the smurf
     * has no more free tiles surrounding it.
     * @return boolean stating true if the smurf is blocked, false if not
     */
    public boolean checkIfWon() {
        return checkFreeNeighbors().isEmpty();
    }

    /**
     * checks if the game is lost by checking if the smurf has
     * less than 6 tiles surrounding it. If so, the smurf must have reached
     * the edge of the board.
     * @return boolean stating true if the smurf reached the edge, false if not
     */
    public boolean checkIfLost(){
        return hexagonNode.getNeighbors().entrySet().size() < 6;
    }

    private List<Hexagon> checkFreeNeighbors() {
        final List<Hexagon> freeNeighbors = new ArrayList<>();
        final List<Hexagon> tilesToCheck = new ArrayList<>();

        tilesToCheck.add(hexagonNode.getNeighbors().get("NW").getHexagon());
        tilesToCheck.add(hexagonNode.getNeighbors().get("NE").getHexagon());
        tilesToCheck.add(hexagonNode.getNeighbors().get("W").getHexagon());
        tilesToCheck.add(hexagonNode.getNeighbors().get("E").getHexagon());
        tilesToCheck.add(hexagonNode.getNeighbors().get("SE").getHexagon());
        tilesToCheck.add(hexagonNode.getNeighbors().get("SW").getHexagon());

        for (final Hexagon hexagon : tilesToCheck) {
            if (Hexagon.State.FREE.equals(hexagon.getCurrentState())) {
                freeNeighbors.add(hexagon);
            }
    }
        return freeNeighbors;
    }


    public Hexagon getSmurfHexagon() {
        return hexagon;
    }
}
