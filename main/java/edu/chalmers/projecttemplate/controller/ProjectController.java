package main.java.edu.chalmers.projecttemplate.controller;

import main.java.edu.chalmers.projecttemplate.model.*;
import main.java.edu.chalmers.projecttemplate.view.ProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ProjectController {
  final private GameHandler gameHandler;

  private Game game;
  private final ProjectView projectView;

  private MouseListenerHexagon mlh;

  public static ProjectController create(GameHandler gameHandler, ProjectView projectView) {
    return new ProjectController(gameHandler, projectView);
  }

  private ProjectController(GameHandler gameHandler, ProjectView projectView) {
    this.gameHandler = gameHandler;
    this.projectView = projectView;

    this.game = gameHandler.getCurrentGame();

    ProjectButtonPressed();

    MouseListenerHexagon mlh = new MouseListenerHexagon();
    for (int i = 0; i<121; i++) {
      projectView.getButton(i).addMouseListener(mlh);
    }

    boardPressedListenerAssigner();

    difficultyRadioButtonPressed();

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
    game.getBoard().getHexagon(pressedTileIndex).blockTile();

    game.NewTurn();
    //bygg ut denna till ett state pattern potentiellt ifall det behövs mer, resonera om varför/varför inte vi gör det

  }
  public void difficultyRadioButtonPressed(){
    ActionListener sliceActionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton aButton = (AbstractButton) actionEvent.getSource();
        System.out.println("Selected: " + aButton.getText());
        if(Objects.equals(aButton.getText(), "Easy")){
            gameHandler.setDifficulty("Easy");
        } else if (Objects.equals(aButton.getText(), "Medium")) {
            gameHandler.setDifficulty("Medium");
        } else if (Objects.equals(aButton.getText(), "Hard")) {
            gameHandler.setDifficulty("Hard");
        }
      }
    };
    projectView.getjRadioButton1().addActionListener(sliceActionListener);
    projectView.getjRadioButton2().addActionListener(sliceActionListener);
    projectView.getjRadioButton3().addActionListener(sliceActionListener);
  }


  private void resetGameCalled (){
    gameHandler.NewGame();
    this.game=gameHandler.getCurrentGame();

    projectView.setProject(gameHandler.getCurrentGame());

    gameHandler.getCurrentGame().getBoard().shuffleBlockedTiles(gameHandler.getDifficulty());

  }
}

