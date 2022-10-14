package main.java.edu.chalmers.projecttemplate.controller;

import main.java.edu.chalmers.projecttemplate.model.*;
import main.java.edu.chalmers.projecttemplate.view.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

public class ProjectController {
  private Project project;
  private final ProjectView projectView;

  MouseListenerHexagon mlh;

  public static ProjectController create(Project project, ProjectView projectView) {
    return new ProjectController(project, projectView);
  }

  private ProjectController(Project project, ProjectView projectView) {
    this.project = project;
    this.projectView = projectView;

    ProjectButtonPressed();

    MouseListenerHexagon mlh = new MouseListenerHexagon();
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

  public void ProjectButtonPressed(){
    this.projectView.getjButton1().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
          resetGameCalled();
        }
      });
    }

  private void listenedObject_actionPerformed(ActionEvent evt) {
    Object pressedTile = evt.getSource();
    int pressedTileIndex = projectView.getButtonBoard().indexOf(pressedTile);
    project.getBoard().getHexagon(pressedTileIndex).blockTile();

    project.NewTurn();
    //bygg ut denna till ett state pattern potentiellt ifall det behövs mer, resonera om varför/varför inte vi gör det

  }
  public void difficultyRadioButtonPressed(){
    ActionListener sliceActionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton aButton = (AbstractButton) actionEvent.getSource();
        System.out.println("Selected: " + aButton.getText());
        if(aButton.getText() == "Easy"){

        } else if (aButton.getText() == "Medium") {

        } else if (aButton.getText()=="Hard") {

        }
      }
    };

    projectView.getjRadioButton1().addActionListener(sliceActionListener);
    projectView.getjRadioButton2().addActionListener(sliceActionListener);
    projectView.getjRadioButton3().addActionListener(sliceActionListener);
  }
  public void difficultyPickedListener(ActionListener difficultyListener){
    projectView.getjRadioButton1().addActionListener(difficultyListener);
    projectView.getjRadioButton2().addActionListener(difficultyListener);
    projectView.getjRadioButton3().addActionListener(difficultyListener);
    if (projectView.getjRadioButton1().isSelected()) {
      System.out.println("hehe");
    }


  }


  private void resetGameCalled (){
    this.project = new Project();


    this.mlh = new MouseListenerHexagon();
    for (int i = 0; i<121; i++) {
      projectView.buttonBoard.get(i).addMouseListener(mlh);
    }

    this.projectView.setProject(this.project);
    this.project.getBoard().addPropertyChangeListener(this.projectView.getObserver());
    this.project.getSmurf().startPlaceSmurf();
    this.project.getBoard().shuffleBlockedTiles();

  }
}

