package main.java.edu.chalmers.projecttemplate.controller;

import main.java.edu.chalmers.projecttemplate.model.*;

import main.java.edu.chalmers.projecttemplate.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

public class ProjectController {
  private final Project project;
  private final myFirstForm projectView;

  public static final int KO = 1;

  public static ProjectController create(Project project, myFirstForm projectView) {
    return new ProjectController(project, projectView);
  }

  private ProjectController(Project project, myFirstForm projectView) {
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
    project.getTile(pressedTileIndex).clickTile();

    //aids
    if (ClickableTile.class.equals(project.getTile(pressedTileIndex).getHexagonStateContext().getCurrentState().getClass())) {
      projectView.getButtonBoard().get(pressedTileIndex).setBackground(Color.red);
      projectView.getButtonBoard().get(pressedTileIndex).setEnabled(true);
    }
    else if (OccupiedTile.class.equals(project.getTile(pressedTileIndex).getHexagonStateContext().getCurrentState().getClass())) {
      projectView.getButtonBoard().get(pressedTileIndex).setBackground(Color.cyan);
      projectView.getButtonBoard().get(pressedTileIndex).setEnabled(false);
    }
    else if (BlockedTile.class.equals(project.getTile(pressedTileIndex).getHexagonStateContext().getCurrentState().getClass())) {
      projectView.getButtonBoard().get(pressedTileIndex).setBackground(Color.darkGray);
      projectView.getButtonBoard().get(pressedTileIndex).setEnabled(false);
    }


    //bygg ut denna till ett state pattern potentiellt ifall det behövs mer, resonera om varför/varför inte vi gör det

  }



  private class ProjectButtonPressed implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      project.incrementPresses();
      projectView.getjLabel1().setText(String.valueOf(project.getPresses()));
    }
  }

}
