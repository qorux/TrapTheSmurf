package main.java.edu.chalmers.projecttemplate;

import main.java.edu.chalmers.projecttemplate.controller.ProjectController;
import main.java.edu.chalmers.projecttemplate.model.Project;
import main.java.edu.chalmers.projecttemplate.model.Smurf;
import main.java.edu.chalmers.projecttemplate.view.myFirstForm;

import javax.swing.SwingUtilities;

public final class ProjectTemplate {
	private ProjectTemplate() {
		/* No instances allowed! */
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				final myFirstForm ProjectView = new myFirstForm();
				final Project project = new Project(ProjectView);

				ProjectController.create(project, ProjectView);
				ProjectView.setVisible(true);
			}
		});
	}
}
