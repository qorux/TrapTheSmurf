package main.java.edu.chalmers.projecttemplate.controller;

import main.java.edu.chalmers.projecttemplate.model.*;
import main.java.edu.chalmers.projecttemplate.view.ProjectView;
import main.java.edu.chalmers.projecttemplate.model.GameHandler.Difficulty;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public final class ProjectController {
  final private GameHandler gameHandler;

  private Game game;
  private final ProjectView projectView;

  private final MouseListenerHexagon mlh;

  public static ProjectController create(GameHandler gameHandler, ProjectView projectView) {
    return new ProjectController(gameHandler, projectView);
  }

  private ProjectController(GameHandler gameHandler, ProjectView projectView) {
    this.gameHandler = gameHandler;
    this.projectView = projectView;

    this.game = gameHandler.getCurrentGame();

    gameButtonPressed();

    mlh = new MouseListenerHexagon();
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
          listenedObjectActionPerformed(evt);
        }
      });
    }
  }

  public void gameButtonPressed(){
    this.projectView.getjButton1().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
          resetGameCalled();
        }
      });
    }

  private void listenedObjectActionPerformed(ActionEvent evt) {
    Object pressedTile = evt.getSource();
    int pressedTileIndex = projectView.getButtonBoard().indexOf(pressedTile);
    game.getBoard().getHexagon(pressedTileIndex).setHexagonState(Hexagon.State.BLOCKED);

    game.newTurn();

  }
  public void difficultyRadioButtonPressed(){
    ActionListener sliceActionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton aButton = (AbstractButton) actionEvent.getSource();
        if(Objects.equals(aButton.getText(), "Easy")){
            gameHandler.setDifficulty(Difficulty.EASY);
        } else if (Objects.equals(aButton.getText(), "Medium")) {
            gameHandler.setDifficulty(Difficulty.MEDIUM);
        } else if (Objects.equals(aButton.getText(), "Hard")) {
            gameHandler.setDifficulty(Difficulty.HARD);
        }
      }
    };
    projectView.getjRadioButton1().addActionListener(sliceActionListener);
    projectView.getjRadioButton2().addActionListener(sliceActionListener);
    projectView.getjRadioButton3().addActionListener(sliceActionListener);
  }

  private void resetGameCalled (){
    gameHandler.newGame();
    this.game=gameHandler.getCurrentGame();
    projectView.setGame(gameHandler.getCurrentGame());
    gameHandler.getCurrentGame().getBoard().shuffleBlockedTiles(gameHandler.getDifficulty());
  }
}

