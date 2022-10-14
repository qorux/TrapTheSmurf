package main.java.edu.chalmers.projecttemplate;

import main.java.edu.chalmers.projecttemplate.controller.ProjectController;
import main.java.edu.chalmers.projecttemplate.model.Project;
import main.java.edu.chalmers.projecttemplate.view.ProjectView;

import javax.swing.SwingUtilities;
import java.util.List;

public final class ProjectTemplate {
	private ProjectTemplate() {
		/* No instances allowed! */
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Project project = new Project();
				final ProjectView ProjectView = new ProjectView(project);

				project.getBoard().addPropertyChangeListener(ProjectView.getObserver());
				project.getSmurf().startPlaceSmurf();
				project.getBoard().shuffleBlockedTiles();

				ProjectController.create(project, ProjectView);
				ProjectView.setVisible(true);

			}
		});
	}
}