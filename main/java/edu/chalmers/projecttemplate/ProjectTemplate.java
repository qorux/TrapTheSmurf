package main.java.edu.chalmers.projecttemplate;

import main.java.edu.chalmers.projecttemplate.controller.ProjectController;
import main.java.edu.chalmers.projecttemplate.model.Game;
import main.java.edu.chalmers.projecttemplate.model.GameHandler;
import main.java.edu.chalmers.projecttemplate.model.Hexagon;
import main.java.edu.chalmers.projecttemplate.view.ProjectView;

import javax.swing.SwingUtilities;

public final class ProjectTemplate {
	private ProjectTemplate() {
		/* No instances allowed! */
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				final GameHandler gameHandler = new GameHandler();
				final Game game = gameHandler.getCurrentGame();

				//kan lägga in kod här och testa så att vyn målar rätt

				final ProjectView projectView = new ProjectView(gameHandler);

				game.getBoard().addPropertyChangeListener(projectView);
				game.getBoard().shuffleBlockedTiles(gameHandler.getDifficulty());
				game.getSmurf().getSmurfHexagon().setHexagonState(Hexagon.State.OCCUPIED);

				ProjectController.create(gameHandler, projectView);
				projectView.setVisible(true);

			}
		});
	}
	/*game.getBoard().getHexagon(3).blockTile();
	game.getBoard().getHexagon(14).blockTile();
	game.getBoard().getHexagon(32).blockTile();
	game.getBoard().getHexagon(112).occupyTile();*/

}