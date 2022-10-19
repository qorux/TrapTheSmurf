package test.java.edu.chalmers.projecttemplate.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.java.edu.chalmers.projecttemplate.model.*;
import org.junit.jupiter.api.Test;

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


}
