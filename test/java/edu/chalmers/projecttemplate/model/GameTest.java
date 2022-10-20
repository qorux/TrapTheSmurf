package test.java.edu.chalmers.projecttemplate.model;

import main.java.edu.chalmers.projecttemplate.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

	@Test
	public void testOnlyOneOccupiedTile() {
		Game game = new Game();
		game.getSmurf().getSmurfHexagon().setHexagonState(Hexagon.State.OCCUPIED);
		List<Integer> tileList = new ArrayList<>();
		for (int i = 0; i < 121; i++) {
			if (game.getBoard().getHexagon(i).getCurrentState().equals(Hexagon.State.OCCUPIED)) {
				tileList.add(i);
			}
		}
		assertEquals(1, tileList.size());
	}

	@Test
	public void testSmurfMoves() {
		Game game = new Game();
		int initialOccupiedTileIndex = 0;
		int nextOccupiedTileIndex = 0;
		for (int i = 0; i < 121; i++) {
			if (game.getBoard().getHexagon(i).getCurrentState().equals(Hexagon.State.OCCUPIED)) {
				initialOccupiedTileIndex = game.getBoard().getHexagon(i).getIndex();
			}
		}
		game.newTurn();
		for (int i = 0; i < 121; i++) {
			if (game.getBoard().getHexagon(i).getCurrentState().equals(Hexagon.State.OCCUPIED)) {
				nextOccupiedTileIndex = game.getBoard().getHexagon(i).getIndex();
			}
		}
		assertNotEquals(initialOccupiedTileIndex, nextOccupiedTileIndex);
	}

	@Test
	public void testNewTurn() {
		Game game = new Game();
		int intialTurn = game.getTurn();
		game.newTurn();
		assertEquals(intialTurn+1, game.getTurn());
	}

}


