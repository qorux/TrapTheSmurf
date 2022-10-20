import main.java.controller.ProjectController;
import main.java.model.*;
import main.java.view.ProjectView;

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

				ProjectController.create(gameHandler, projectView);
				projectView.setVisible(true);

			}
		});
	}
}