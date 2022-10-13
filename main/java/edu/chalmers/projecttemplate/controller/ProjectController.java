package main.java.edu.chalmers.projecttemplate.controller;

import main.java.edu.chalmers.projecttemplate.model.*;
import main.java.edu.chalmers.projecttemplate.view.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

public class ProjectController {
  private final Project project;
  private final ProjectView projectView;

  public static ProjectController create(Project project, ProjectView projectView) {
    return new ProjectController(project, projectView);
  }

  private ProjectController(Project project, ProjectView projectView) {
    this.project = project;
    this.projectView = projectView;


    projectView.getjButton1().addActionListener(new ProjectButtonPressed());  //onödigt

    MouseListenerHexagon mlh = new MouseListenerHexagon(project, projectView);
    for (int i = 0; i<121; i++) {
      projectView.buttonBoard.get(i).addMouseListener(mlh);
    }

    boardPressedListenerAssigner();

  }

  public void boardPressedListenerAssigner(){
    for (int counter = 0; counter < this.projectView.getButtonBoard().size(); counter++) {
      this.projectView.getButtonBoard().get(counter).addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
          listenedObject_actionPerformed(evt);
        }
      });
    }
  }

  private void listenedObject_actionPerformed(ActionEvent evt) {
    Object pressedTile = evt.getSource();
    int pressedTileIndex = projectView.getButtonBoard().indexOf(pressedTile);
    project.getBoard().getHexagon(pressedTileIndex).blockTile();

    project.NewTurn();
    //bygg ut denna till ett state pattern potentiellt ifall det behövs mer, resonera om varför/varför inte vi gör det

  }

/*  public void difficultyPickedListener(ActionListener difficultyListener){
    projectView.getjRadioButton1().addActionListener(difficultyListener);
    projectView.getjRadioButton2().addActionListener(difficultyListener);
    projectView.getjRadioButton3().addActionListener(difficultyListener);
    if (projectView.getjRadioButton1().isSelected()) {
      System.out.println("hehe");
    }


  }*/


  private class ProjectButtonPressed implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {


      Project project = new Project();
      ProjectView ProjectView = new ProjectView(project);

      project.getBoard().addPropertyChangeListener(ProjectView.getObserver());
      project.getSmurf().startPlaceSmurf();
      project.getBoard().shuffleBlockedTiles();

      ProjectController.create(project, ProjectView);
      ProjectView.setVisible(true);
      projectView.setVisible(false);
/*
      Project project = new Project();

      projectView.setProject(project);
      project.getBoard().addPropertyChangeListener(projectView.getObserver());
      project.getSmurf().startPlaceSmurf();
      project.getBoard().shuffleBlockedTiles();*/

    }
  }
}
