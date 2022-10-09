package main.java.edu.chalmers.projecttemplate.controller;

import main.java.edu.chalmers.projecttemplate.ProjectTemplate;
import main.java.edu.chalmers.projecttemplate.model.*;
import main.java.edu.chalmers.projecttemplate.view.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProjectController {
  private final Project project;
  private final ProjectView projectView;

  public static final int KO = 1;

  public static ProjectController create(Project project, ProjectView projectView) {
    return new ProjectController(project, projectView);
  }

  private ProjectController(Project project, ProjectView projectView) {
    this.project = project;
    this.projectView = projectView;

    projectView.getjButton1().addActionListener(new ProjectButtonPressed());  //onödigt

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
    project.board.getHexagon(pressedTileIndex).blockTile();

    project.NewTurn();
    //bygg ut denna till ett state pattern potentiellt ifall det behövs mer, resonera om varför/varför inte vi gör det

  }



  private class ProjectButtonPressed implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {


      Project project = new Project();
      ProjectView ProjectView = new ProjectView(project);

      project.board.addPropertyChangeListener(ProjectView.getObserver());
      project.getSmurf().startPlaceSmurf();
      List<Boolean> tilesToBlock = project.board.randomizeBlockedTiles();
      project.board.shuffleBlockedTiles(tilesToBlock);

      ProjectController.create(project, ProjectView);
      ProjectView.setVisible(true);
      projectView.setVisible(false);

      System.out.println("Hej, jag kommer hit");

      //projectView.getjLabel1().setText(String.valueOf(project.getPresses()));
    }
  }
}
