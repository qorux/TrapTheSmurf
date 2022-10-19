package test.java.edu.chalmers.projecttemplate.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.java.edu.chalmers.projecttemplate.controller.ProjectController;
import main.java.edu.chalmers.projecttemplate.model.*;
import main.java.edu.chalmers.projecttemplate.view.ProjectView;
import main.java.edu.chalmers.projecttemplate.model.Game;
import org.junit.jupiter.api.Test;
import main.java.edu.chalmers.projecttemplate.model.GameHandler.Difficulty;

import java.util.List;

public class BoardTest {

    @Test
    public void testForOutOfBoundsError() {
        GameHandler gameHandler = new GameHandler();
        Game game = gameHandler.getCurrentGame();
        ProjectView projectView = new ProjectView(gameHandler);
        for (int i = 0; i < 121; i++) {
            game.getBoard().blockTile(i);
        }
        ProjectController.create(gameHandler, projectView);
        projectView.setVisible(true);
        assertTrue(true);
    }

/*    //Bör läggas i en annan klass "TestVew" typ
    @Test
    public void testViewPropertyChange() {
        Project project = new Project();
        ProjectView projectView = new ProjectView(project); //Ok så efter lite googling verkar det inte som kan
        for (int i = 0; i < 121; i++) {                     // JUnit testa viewn.. rip
            project.board.getHexagon(i).makeClickable();
        }
        project.board.getHexagon(3).blockTile();
        project.board.getHexagon(14).blockTile();
        project.board.getHexagon(32).blockTile();
        project.board.getHexagon(112).occupyTile();

        projectView.setVisible(true);
    }*/


    @Test
    public void testBlockTile() {
        Game game = new Game(Difficulty.DEFAULT);
        for (int i = 0; i < 121; i++) {
            game.getBoard().blockTile(i);
            if (i == 60) {
                assertEquals(game.getBoard().getHexagon(60).getCurrentState(), Hexagon.State.OCCUPIED);
            }
            else {
                assertEquals(game.getBoard().getHexagon(60).getCurrentState(), Hexagon.State.BLOCKED);
            }
        }
    }
/*

Gav private access till detta så nu funkar det inte längre
    @Test
    public void testRandomizeBlockedTiles() {
        Project project = new Project();
        List<Boolean> tilesToBlock = project.getBoard().randomizeBlockedTiles();
        int expectedBlockedTiles = 0;
        for (Boolean aBoolean : tilesToBlock) {
            if (aBoolean == Boolean.TRUE) {
                expectedBlockedTiles++;
            }
        }
        project.getBoard().shuffleBlockedTiles(tilesToBlock);
        int actualBlockedTiles = 0;
        for (int i = 0; i < 121; i++) {
            if (project.getBoard().getHexagon(i).getHexagonStateContext().getCurrentState().getClass().equals(BlockedTile.class)) {
                actualBlockedTiles++;
            }
        }
        assertEquals(expectedBlockedTiles, actualBlockedTiles);
    }



 */

    @Test
    void easyDifficultyTest() {
        Game game = new Game(Difficulty.EASY);
        int blockedTiles = game.getBoard().difficultyBlockedTiles(Difficulty.EASY);
        assertTrue(15 <= blockedTiles && blockedTiles <= 20);
    }

    @Test
    void mediumDifficultyTest() {
        Game game = new Game(Difficulty.MEDIUM);
        int blockedTiles = game.getBoard().difficultyBlockedTiles(Difficulty.MEDIUM);
        assertTrue(7 <= blockedTiles && blockedTiles <= 13);
    }

    @Test
    void hardDifficultyTest() {
        Game game = new Game(Difficulty.HARD);
        int blockedTiles = game.getBoard().difficultyBlockedTiles(Difficulty.HARD);
        assertTrue(2 <= blockedTiles && blockedTiles <= 7);
    }

    @Test
    void getHexagonCoordinateTest() {
        Game game = new Game(Difficulty.DEFAULT);
        Hexagon hexagonByCoordinate = game.getBoard().getHexagonCoordinate(0,0);
        Hexagon hexagonByIndex = game.getBoard().getHexagon(0);
        assertEquals(hexagonByIndex,hexagonByCoordinate);

        hexagonByCoordinate = game.getBoard().getHexagonCoordinate(10,10);
        hexagonByIndex = game.getBoard().getHexagon(120);
        assertEquals(hexagonByIndex,hexagonByCoordinate);

        hexagonByCoordinate = game.getBoard().getHexagonCoordinate(5,5);
        hexagonByIndex = game.getBoard().getHexagon(60);
        assertEquals(hexagonByIndex,hexagonByCoordinate);

        hexagonByCoordinate = game.getBoard().getHexagonCoordinate(6,5);
        hexagonByIndex = game.getBoard().getHexagon(61);
        assertEquals(hexagonByIndex,hexagonByCoordinate);

        hexagonByCoordinate = game.getBoard().getHexagonCoordinate(4,5);
        hexagonByIndex = game.getBoard().getHexagon(59);
        assertEquals(hexagonByIndex,hexagonByCoordinate);

    }

    @Test
    void getHexagonCoordinateGetTest() {
        Game game = new Game(Difficulty.DEFAULT);
        Hexagon hexagonByCoordinate = game.getBoard().getHexagonCoordinate(0,0);
        Hexagon hexagonByGet = game.getBoard().getBoardSpaces().get(0).get(0);
        assertEquals(hexagonByGet,hexagonByCoordinate);

        hexagonByCoordinate = game.getBoard().getHexagonCoordinate(4,5);
        hexagonByGet = game.getBoard().getBoardSpaces().get(5).get(4);
        assertEquals(hexagonByGet,hexagonByCoordinate);

    }

    @Test
    void getHexagonNodeIndexTest() {
        Game game = new Game(Difficulty.DEFAULT);
        Node nodeByIndex = game.getBoard().getNode(60);
        Hexagon hexagonByIndex = game.getBoard().getHexagon(60);
        assertEquals(nodeByIndex.getHexagon().getIndex(), hexagonByIndex.getIndex());
        assertEquals(nodeByIndex.getHexagon(), hexagonByIndex);
    }

    @Test
    void getNeighboursTest() {
        Game game = new Game(Difficulty.DEFAULT);
        List<List<Node>> boardNodesColumns = game.getBoard().getBoardNodesColumns();

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
