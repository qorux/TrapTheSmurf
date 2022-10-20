package main.java.edu.chalmers.projecttemplate.controller;

import main.java.edu.chalmers.projecttemplate.model.*;
import main.java.edu.chalmers.projecttemplate.view.ProjectView;
import main.java.edu.chalmers.projecttemplate.model.GameHandler.Difficulty;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ProjectController {
  final private GameHandler gameHandler;

  private Game game;
  private final ProjectView projectView;

  public static ProjectController create(final GameHandler gameHandler,final ProjectView projectView) {
    return new ProjectController(gameHandler, projectView);
  }

  private ProjectController(final GameHandler gameHandler,final ProjectView projectView) {
    this.gameHandler = gameHandler;
    this.projectView = projectView;

    this.game = gameHandler.getCurrentGame();

    gameButtonPressed();

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
        public void actionPerformed(final ActionEvent evt) {
          listenedObjectActionPerformed(evt);
        }
      });
    }
  }

  public void gameButtonPressed(){
    this.projectView.getjButton1().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent evt) {
          resetGameCalled();
        }
      });
    }

  private void listenedObjectActionPerformed(final ActionEvent evt) {
    final Object pressedTile = evt.getSource();
    final int pressedTileIndex = projectView.getButtonBoard().indexOf(pressedTile);
    game.getBoard().getHexagon(pressedTileIndex).setHexagonState(Hexagon.State.BLOCKED);

    game.newTurn();

  }
  public void difficultyRadioButtonPressed(){
    final ActionListener actionListener = new ActionListener() {
      public void actionPerformed(final ActionEvent actionEvent) {
        final AbstractButton aButton = (AbstractButton) actionEvent.getSource();
        if(Objects.equals(aButton.getText(), "Easy")){
            gameHandler.setDifficulty(Difficulty.EASY);
        } else if (Objects.equals(aButton.getText(), "Medium")) {
            gameHandler.setDifficulty(Difficulty.MEDIUM);
        } else if (Objects.equals(aButton.getText(), "Hard")) {
            gameHandler.setDifficulty(Difficulty.HARD);
        }
      }
    };
    projectView.getjRadioButton1().addActionListener(actionListener);
    projectView.getjRadioButton2().addActionListener(actionListener);
    projectView.getjRadioButton3().addActionListener(actionListener);
  }

  private void resetGameCalled (){
    gameHandler.newGame();
    this.game=gameHandler.getCurrentGame();
    projectView.setGame(gameHandler.getCurrentGame());
    gameHandler.getCurrentGame().getBoard().shuffleBlockedTiles(gameHandler.getDifficulty());
    game.getSmurf().getSmurfHexagon().setHexagonState(Hexagon.State.OCCUPIED);
  }
}

