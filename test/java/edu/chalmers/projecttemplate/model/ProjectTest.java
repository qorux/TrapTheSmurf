package test.java.edu.chalmers.projecttemplate.model;

import main.java.edu.chalmers.projecttemplate.controller.ProjectController;
import main.java.edu.chalmers.projecttemplate.model.*;
import main.java.edu.chalmers.projecttemplate.view.ProjectView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectTest {
	private static final int NUM_INCREMENTATIONS = 128;

	@Test //Ta bort denna ?
	public void testIncrementResult() {
		final var project = new Project();
		final var projectView = new ProjectView(project);
		//fixa packages

		for (var i = 0; i < ProjectTest.NUM_INCREMENTATIONS; i++) {
			project.incrementPresses();
		}

		assertEquals(ProjectTest.NUM_INCREMENTATIONS, project.getPresses());
	}

	@Test
	public void testNewTurn() {
		Project project = new Project();
		int initialOccupiedTileIndex = 0;
		int nextOccupiedTileIndex = 0;
		for (int i = 0; i < 121; i++) {
			if (project.board.getHexagon(i).getHexagonStateContext().getCurrentState().getClass().equals(OccupiedTile.class)) {
				initialOccupiedTileIndex = project.board.getHexagon(i).getIndex();
			}
		}
		project.NewTurn();
		for (int i = 0; i < 121; i++) {
			if (project.board.getHexagon(i).getHexagonStateContext().getCurrentState().getClass().equals(OccupiedTile.class)) {
				nextOccupiedTileIndex = project.board.getHexagon(i).getIndex();
			}
		}
		assertNotEquals(initialOccupiedTileIndex, nextOccupiedTileIndex);
	}

}
