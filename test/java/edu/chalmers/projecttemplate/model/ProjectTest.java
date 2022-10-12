package test.java.edu.chalmers.projecttemplate.model;

import main.java.edu.chalmers.projecttemplate.controller.ProjectController;
import main.java.edu.chalmers.projecttemplate.model.*;
import main.java.edu.chalmers.projecttemplate.view.ProjectView;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectTest {
	private static final int NUM_INCREMENTATIONS = 128;

	@Test
	public void testOnlyOneOccupiedTile() {
		Project project = new Project();
		List<Integer> tileList = new ArrayList<>();
		for (int i = 0; i < 121; i++) {
			if (project.board.getHexagon(i).getHexagonStateContext().getCurrentState().getClass().equals(OccupiedTile.class)) {
				tileList.add(i);
			}
		}
		assertEquals(1, tileList.size());
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


