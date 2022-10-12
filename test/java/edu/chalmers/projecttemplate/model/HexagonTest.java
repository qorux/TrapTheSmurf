package test.java.edu.chalmers.projecttemplate.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.java.edu.chalmers.projecttemplate.controller.ProjectController;
import main.java.edu.chalmers.projecttemplate.model.*;
import main.java.edu.chalmers.projecttemplate.view.ProjectView;
import org.junit.jupiter.api.Test;

public class HexagonTest {


    @Test
    void occupyTile() {
        Project project = new Project();
        project.getBoard().getHexagon(1).makeClickable();
        assertEquals(project.getBoard().getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), ClickableTile.class);
        project.getBoard().getHexagon(1).occupyTile();
        assertEquals(project.getBoard().getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), OccupiedTile.class);
    }

    @Test
    void blockTile() {
       Project project = new Project();
       project.getBoard().getHexagon(1).makeClickable();
       assertEquals(project.getBoard().getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), ClickableTile.class);
       project.getBoard().getHexagon(1).blockTile();
       assertEquals(project.getBoard().getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), BlockedTile.class);
    }


    @Test
    void makeClickableFromBlocked() {
        Project project = new Project();
        project.getBoard().getHexagon(1).blockTile();
        assertEquals(project.getBoard().getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), BlockedTile.class);
        project.getBoard().getHexagon(1).makeClickable();
        assertEquals(project.getBoard().getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), ClickableTile.class);
    }

    @Test
    void makeClickableFromOccupied() {
        Project project = new Project();
        project.getBoard().getHexagon(1).occupyTile();
        assertEquals(project.getBoard().getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), OccupiedTile.class);
        project.getBoard().getHexagon(1).makeClickable();
        assertEquals(project.getBoard().getHexagon(1).getHexagonStateContext().getCurrentState().getClass(), ClickableTile.class);
    }


}
