package test.java.edu.chalmers.projecttemplate.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.java.edu.chalmers.projecttemplate.controller.ProjectController;
import main.java.edu.chalmers.projecttemplate.model.*;
import main.java.edu.chalmers.projecttemplate.view.ProjectView;
import main.java.edu.chalmers.projecttemplate.model.Project;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @Test
    void getHexagonNodeIndexTest() {
        Project project= new Project();
        Node nodeByIndex = project.board.getNode(60);
        Hexagon hexagonByIndex = project.board.getHexagon(60);
        assertEquals(nodeByIndex.getHexagon().getIndex(), hexagonByIndex.getIndex());
        assertEquals(nodeByIndex.getHexagon(), hexagonByIndex);
    }

    @Test
    void getNeighboursTest() {
        Project project= new Project();
        List<List<Node>> boardNodesColumns = project.getBoard().getBoardNodesColumns();

        assertEquals(2, boardNodesColumns.get(0).get(0).getNeighbors().size());
        assertEquals(1, boardNodesColumns.get(0).get(0).getNeighbors().get("E").getHexagon().getIndex());
        assertEquals(11, boardNodesColumns.get(0).get(0).getNeighbors().get("SE").getHexagon().getIndex());

        assertEquals(6, boardNodesColumns.get(5).get(5).getNeighbors().size());
        assertEquals(59, boardNodesColumns.get(5).get(5).getNeighbors().get("W").getHexagon().getIndex());
        assertEquals(61, boardNodesColumns.get(5).get(5).getNeighbors().get("E").getHexagon().getIndex());
        assertEquals(49, boardNodesColumns.get(5).get(5).getNeighbors().get("NW").getHexagon().getIndex());
        assertEquals(50, boardNodesColumns.get(5).get(5).getNeighbors().get("NE").getHexagon().getIndex());
        assertEquals(71, boardNodesColumns.get(5).get(5).getNeighbors().get("SW").getHexagon().getIndex());
        assertEquals(72, boardNodesColumns.get(5).get(5).getNeighbors().get("SE").getHexagon().getIndex());

        assertEquals(5, boardNodesColumns.get(1).get(0).getNeighbors().size());
        assertEquals(12, boardNodesColumns.get(1).get(0).getNeighbors().get("E").getHexagon().getIndex());
        assertEquals(0, boardNodesColumns.get(1).get(0).getNeighbors().get("NW").getHexagon().getIndex());
        assertEquals(1, boardNodesColumns.get(1).get(0).getNeighbors().get("NE").getHexagon().getIndex());
        assertEquals(22, boardNodesColumns.get(1).get(0).getNeighbors().get("SW").getHexagon().getIndex());
        assertEquals(23, boardNodesColumns.get(1).get(0).getNeighbors().get("SE").getHexagon().getIndex());

        
        assertEquals(3, boardNodesColumns.get(2).get(0).getNeighbors().size());
        assertEquals(11, boardNodesColumns.get(2).get(0).getNeighbors().get("NE").getHexagon().getIndex());
        assertEquals(23, boardNodesColumns.get(2).get(0).getNeighbors().get("E").getHexagon().getIndex());
        assertEquals(33, boardNodesColumns.get(2).get(0).getNeighbors().get("SE").getHexagon().getIndex());

/*
        System.out.println("Last Hexagon neighbours: " + boardNodesColumns.get(10).get(10).getNeighbors().size());
        System.out.println("Last Hexagon neighbours: " + boardNodesColumns.get(10).get(10).getNeighbors().get("NW").getHexagon().getIndex());
        System.out.println("Last Hexagon neighbours: " + boardNodesColumns.get(10).get(10).getNeighbors().get("NE").getHexagon().getIndex());
        System.out.println("Last Hexagon neighbours: " + boardNodesColumns.get(10).get(10).getNeighbors().get("W").getHexagon().getIndex());


 */
        assertEquals(3, boardNodesColumns.get(5).get(10).getNeighbors().size());
        assertEquals(54, boardNodesColumns.get(5).get(10).getNeighbors().get("NW").getHexagon().getIndex());
        assertEquals(64, boardNodesColumns.get(5).get(10).getNeighbors().get("W").getHexagon().getIndex());
        assertEquals(76, boardNodesColumns.get(5).get(10).getNeighbors().get("SW").getHexagon().getIndex());


    }
}
