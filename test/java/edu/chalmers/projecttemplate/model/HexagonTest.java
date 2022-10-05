package test.java.edu.chalmers.projecttemplate.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.java.edu.chalmers.projecttemplate.controller.ProjectController;
import main.java.edu.chalmers.projecttemplate.model.*;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeSupport;

public class HexagonTest {

    private PropertyChangeSupport support;


    @Test
    void getSupport() {
    }

    @Test
    void getHexagonStateContext() {
    }

    //Funkar inte riktigt just nu, blir nått skumt med Support. Fattar inte riktigt vad det är för nått ?

    @Test
    void occupyTile() {
        Project project = new Project();
        Hexagon freeTile = new Hexagon(1, support);
        freeTile.occupyTile();
        assertEquals(project.board.getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), OccupiedTile.class);
    }

    @Test
    void blockTile() {
        Project project = new Project();
        Hexagon freeTile = new Hexagon(1, support);
        freeTile.blockTile();
        assertEquals(project.board.getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), BlockedTile.class);
    }

    @Test
    void makeClickable() {
        Project project = new Project();
        Hexagon testTile = new Hexagon(1, support);
        testTile.blockTile();
        assertEquals(project.board.getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), BlockedTile.class);
        testTile.makeClickable();
        assertEquals(project.board.getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), ClickableTile.class);
    }

    @Test
    void getIndex() {
    }
}
