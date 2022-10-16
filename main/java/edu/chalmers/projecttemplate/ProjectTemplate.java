package main.java.edu.chalmers.projecttemplate;

import main.java.edu.chalmers.projecttemplate.controller.ProjectController;
import main.java.edu.chalmers.projecttemplate.model.Game;
import main.java.edu.chalmers.projecttemplate.model.GameHandler;
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
				Game game = gameHandler.getCurrentGame();
				final ProjectView ProjectView = new ProjectView(game);


				game.getBoard().addPropertyChangeListener(ProjectView);
				game.getBoard().shuffleBlockedTiles(gameHandler.getDifficulty());

				ProjectController.create(gameHandler, ProjectView);
				ProjectView.setVisible(true);

			}
		});
	}
}