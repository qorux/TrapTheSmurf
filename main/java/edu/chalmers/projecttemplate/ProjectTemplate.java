package main.java.edu.chalmers.projecttemplate;

import main.java.edu.chalmers.projecttemplate.controller.ProjectController;
import main.java.edu.chalmers.projecttemplate.model.OHexagonStateContext;
import main.java.edu.chalmers.projecttemplate.model.Project;
import main.java.edu.chalmers.projecttemplate.model.Smurf;
import main.java.edu.chalmers.projecttemplate.view.OHexagonButtonState;
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
				final Project project = new Project();
				final myFirstForm ProjectView = new myFirstForm(project);

				for(int i=0; i<=120;i++){
					project.board.getBoardSpaces().get(i).getHexagonStateContext().addObserver(ProjectView.observer);
				}
				project.board.randomizeBlockedTiles();
				project.getSmurf().moveSmurf(project.board.getBoardSpaces().get(58)); //hur gör vi här
				ProjectController.create(project, ProjectView);
				ProjectView.setVisible(true);

			}
		});
	}
}
