package test.java.edu.chalmers.projecttemplate.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.java.edu.chalmers.projecttemplate.model.*;
import org.junit.jupiter.api.Test;

public class HexagonTest {


    @Test
    void occupyTile() {
        Game game = new Game("Default");
        game.getBoard().getHexagon(1).makeClickable();
        assertEquals(game.getBoard().getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), FreeTile.class);
        game.getBoard().getHexagon(1).occupyTile();
        assertEquals(game.getBoard().getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), OccupiedTile.class);
    }

    @Test
    void blockTile() {
       Game game = new Game("Default");
       game.getBoard().getHexagon(1).makeClickable();
       assertEquals(game.getBoard().getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), FreeTile.class);
       game.getBoard().getHexagon(1).blockTile();
       assertEquals(game.getBoard().getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), BlockedTile.class);
    }


    @Test
    void makeClickableFromBlocked() {
        Game game = new Game("Default");
        game.getBoard().getHexagon(1).blockTile();
        assertEquals(game.getBoard().getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), BlockedTile.class);
        game.getBoard().getHexagon(1).makeClickable();
        assertEquals(game.getBoard().getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), FreeTile.class);
    }

    @Test
    void makeClickableFromOccupied() {
        Game game = new Game("Default");
        game.getBoard().getHexagon(1).occupyTile();
        assertEquals(game.getBoard().getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), OccupiedTile.class);
        game.getBoard().getHexagon(1).makeClickable();
        assertEquals(game.getBoard().getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), FreeTile.class);
    }


}
