package main.java.edu.chalmers.projecttemplate.controller;

import main.java.edu.chalmers.projecttemplate.model.*;

import main.java.edu.chalmers.projecttemplate.view.*;

import javax.swing.*;
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
    boardPressedListener BoardPressedListener = new boardPressedListener();

    for (int counter = 0; counter < this.projectView.getButtonBoard().size(); counter++) {
      this.projectView.getButtonBoard().get(counter).addActionListener(BoardPressedListener);
    }
  }

  private class ProjectButtonPressed implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      project.incrementPresses();
      projectView.getjLabel1().setText(String.valueOf(project.getPresses()));
    }
  }

  private class boardPressedListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      Object pressedTile = e.getSource();
      int pressedTileIndex = projectView.getButtonBoard().indexOf(pressedTile);
      project.board.getBoardSpaces().get(pressedTileIndex).switchState();
      System.out.print("Switched states of button nr. ");
      System.out.println(pressedTileIndex);

    }
  }
}
