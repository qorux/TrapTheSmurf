package main.java.edu.chalmers.projecttemplate.model;

import main.java.edu.chalmers.projecttemplate.ProjectTemplate;
import main.java.edu.chalmers.projecttemplate.controller.ProjectController;
import main.java.edu.chalmers.projecttemplate.view.ProjectView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project {
  public static final String PROJECT_WINDOW_TEXT = "ProjectTemplate";
  public static final String PROJECT_BUTTON_TEXT = "Press me!";
  private int presses;

  private boolean hasWon;

  private int turn = 0;
  private Board board;//borde va private

  private Smurf smurf;
  public Project(){
    this.board = new Board();
    this.smurf=new Smurf(board);
  }


  public Board getBoard() {
    return board;
  }

  public Smurf getSmurf() {
    return smurf;
  }

  /**
   * Increments the turn variable which is displayed in the game,
   * then tells the smurf to make its move
   */
  public void NewTurn(){
    if (smurf.checkIfWon()) {
      hasWon = true;
      System.out.println("You won");
    }
    else {
      turn++;
    smurf.moveSmurf(); }
  }


  public int getTurn() {
    return turn;
  }

  public boolean isHasWon() {
    return hasWon;
  }



}