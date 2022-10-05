package main.java.edu.chalmers.projecttemplate;

import main.java.edu.chalmers.projecttemplate.controller.ProjectController;
import main.java.edu.chalmers.projecttemplate.model.Board;
import main.java.edu.chalmers.projecttemplate.model.Project;
import main.java.edu.chalmers.projecttemplate.view.myFirstForm;

import javax.swing.SwingUtilities;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class ProjectTemplate {
	private ProjectTemplate() {
		/* No instances allowed! */
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				final Project project = new Project();
				final myFirstForm ProjectView = new myFirstForm(project);

				project.board.addPropertyChangeListener(ProjectView.getObserver());
				project.getSmurf().startPlaceSmurf();
				List<Boolean> tilesToBlock = project.board.randomizeBlockedTiles();
				project.board.shuffleBlockedTiles(tilesToBlock);

				ProjectController.create(project, ProjectView);
				ProjectView.setVisible(true);
			}
		});
	}
}
