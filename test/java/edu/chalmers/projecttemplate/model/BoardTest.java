package test.java.edu.chalmers.projecttemplate.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.java.edu.chalmers.projecttemplate.controller.ProjectController;
import main.java.edu.chalmers.projecttemplate.model.*;
import main.java.edu.chalmers.projecttemplate.view.ProjectView;
import main.java.edu.chalmers.projecttemplate.model.Project;
import main.java.edu.chalmers.projecttemplate.view.myFirstForm;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BoardTest {

    @Test
    public void testForOutOfBoundsError() {
        Project project = new Project();
        ProjectView projectView = new ProjectView(project);
        for (int i = 0; i < 121; i++) {
            project.board.blockTile(i);
        }
        ProjectController.create(project, projectView);
        projectView.setVisible(true);
        assertTrue(true);
    }

    @Test
    public void testBlockTile() {
        Project project = new Project();
        for (int i = 0; i < 121; i++) {
            project.board.blockTile(i);
            if (i == 60) {
                assertEquals(project.board.getHexagon(60).getHexagonStateContext().getCurrentState().getClass(), OccupiedTile.class);
            }
            else {
                assertEquals(project.board.getHexagon(i).getHexagonStateContext().getCurrentState().getClass(), BlockedTile.class);
            }
        }
    }

    @Test
    public void testRandomizeBlockedTiles() {
        Project project = new Project();
        List<Boolean> tilesToBlock = project.board.randomizeBlockedTiles();
        int expectedBlockedTiles = 0;
        for (Boolean aBoolean : tilesToBlock) {
            if (aBoolean == Boolean.TRUE) {
                expectedBlockedTiles++;
            }
        }
        project.board.shuffleBlockedTiles(tilesToBlock);
        int actualBlockedTiles = 0;
        for (int i = 0; i < 121; i++) {
            if (project.board.getHexagon(i).getHexagonStateContext().getCurrentState().getClass().equals(BlockedTile.class)) {
                actualBlockedTiles++;
            }
        }
        assertEquals(expectedBlockedTiles, actualBlockedTiles);
    }

    @Test
    void getHexagonCoordinateTest() {
        Project project= new Project();
        Hexagon hexagonByCoordinate = project.board.getHexagonCoordinate(0,0);
        Hexagon hexagonByIndex = project.board.getHexagon(0);
        assertEquals(hexagonByIndex,hexagonByCoordinate);

        hexagonByCoordinate = project.board.getHexagonCoordinate(10,10);
        hexagonByIndex = project.board.getHexagon(120);
        assertEquals(hexagonByIndex,hexagonByCoordinate);

        hexagonByCoordinate = project.board.getHexagonCoordinate(5,5);
        hexagonByIndex = project.board.getHexagon(60);
        assertEquals(hexagonByIndex,hexagonByCoordinate);

        hexagonByCoordinate = project.board.getHexagonCoordinate(6,5);
        hexagonByIndex = project.board.getHexagon(61);
        assertEquals(hexagonByIndex,hexagonByCoordinate);

        hexagonByCoordinate = project.board.getHexagonCoordinate(4,5);
        hexagonByIndex = project.board.getHexagon(59);
        assertEquals(hexagonByIndex,hexagonByCoordinate);

    }

    @Test
    void getHexagonCoordinateGetTest() {
        Project project= new Project();
        Hexagon hexagonByCoordinate = project.board.getHexagonCoordinate(0,0);
        Hexagon hexagonByGet = project.board.getBoardSpaces().get(0).get(0);
        assertEquals(hexagonByGet,hexagonByCoordinate);

        hexagonByCoordinate = project.board.getHexagonCoordinate(4,5);
        hexagonByGet = project.board.getBoardSpaces().get(5).get(4);
        assertEquals(hexagonByGet,hexagonByCoordinate);

    }
}
