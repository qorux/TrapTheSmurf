package test.java.edu.chalmers.projecttemplate.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.java.edu.chalmers.projecttemplate.model.*;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.Map;

public class HexagonTest {


    @Test
    void occupyTile() {
        Game game = new Game();
        game.getBoard().getHexagon(1).setHexagonState(Hexagon.State.FREE);
        assertEquals(game.getBoard().getHexagon(1).getCurrentState(), Hexagon.State.FREE);
        game.getBoard().getHexagon(1).setHexagonState(Hexagon.State.OCCUPIED);
        assertEquals(game.getBoard().getHexagon(1).getCurrentState(), Hexagon.State.OCCUPIED);
    }

    @Test
    void blockTile() {
        Game game = new Game();
        game.getBoard().getHexagon(1).setHexagonState(Hexagon.State.FREE);
        assertEquals(game.getBoard().getHexagon(1).getCurrentState(), Hexagon.State.FREE);
        game.getBoard().getHexagon(1).setHexagonState(Hexagon.State.BLOCKED);
        assertEquals(game.getBoard().getHexagon(1).getCurrentState(), Hexagon.State.BLOCKED);
    }


    @Test
    void makeClickableFromBlocked() {
        Game game = new Game();
        game.getBoard().getHexagon(1).setHexagonState(Hexagon.State.BLOCKED);
        assertEquals(game.getBoard().getHexagon(1).getCurrentState(), Hexagon.State.BLOCKED);
        game.getBoard().getHexagon(1).setHexagonState(Hexagon.State.FREE);
        assertEquals(game.getBoard().getHexagon(1).getCurrentState(), Hexagon.State.FREE);
    }

    @Test
    void makeClickableFromOccupied() {
        Game game = new Game();
        game.getBoard().getHexagon(1).setHexagonState(Hexagon.State.OCCUPIED);
        assertEquals(game.getBoard().getHexagon(1).getCurrentState(), Hexagon.State.OCCUPIED);
        game.getBoard().getHexagon(1).setHexagonState(Hexagon.State.FREE);
        assertEquals(game.getBoard().getHexagon(1).getCurrentState(), Hexagon.State.FREE);
    }


    @Test
    void getAndSetCurrentState() {
        Game game = new Game();
        Hexagon hexagon = game.getBoard().getHexagon(2);
        hexagon.setHexagonState(Hexagon.State.FREE);
        assertEquals(hexagon.getCurrentState(), Hexagon.State.FREE);
        hexagon.setHexagonState(Hexagon.State.BLOCKED);
        assertEquals(hexagon.getCurrentState(), Hexagon.State.BLOCKED);
        hexagon.setHexagonState(Hexagon.State.OCCUPIED);
        assertEquals(hexagon.getCurrentState(), Hexagon.State.OCCUPIED);

    }

    @Test
    void getIndex() {
        Game game = new Game();
        Hexagon hexagon = game.getBoard().getHexagon(1);
        assertEquals(hexagon.getIndex(), 1);
    }

    @Test
    void getHexagon() {
        Game game = new Game();
        Hexagon hexagon = game.getBoard().getHexagon(1);
        Node node = new Node(hexagon);
        assertEquals(node.getHexagon(), hexagon);
    }

    @Test
    void getNeighbors() {
        Game game = new Game();
        Hexagon hexagon = game.getBoard().getHexagon(2);
        Node node = new Node(hexagon);
        Map<String, Node> map = node.getNeighbors();
        assertEquals(map, node.getNeighbors());
    }
}
