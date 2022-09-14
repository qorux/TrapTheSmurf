package main.java.edu.chalmers.projecttemplate.controller;

import main.java.edu.chalmers.projecttemplate.model.Project;

import main.java.edu.chalmers.projecttemplate.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectController {
  private final Project project;
  private final myFirstForm projectView;
  public static final int KO = 1;

  public static ProjectController create(Project project, myFirstForm projectView) {
    return new ProjectController(project, projectView);
  }

  private ProjectController(Project project, myFirstForm projectView) {
    projectView.getjButton1().addActionListener(new ProjectButtonPressed());

    this.project = project;
    this.projectView = projectView;
  }

  private class ProjectButtonPressed implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      project.incrementPresses();
      projectView.getjLabel1().setText(String.valueOf(project.getPresses()));
    }
  }
}
