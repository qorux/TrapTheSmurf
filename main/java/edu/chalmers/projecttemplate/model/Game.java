package main.java.edu.chalmers.projecttemplate.model;

import java.beans.PropertyChangeSupport;

public class Game {
  private boolean hasWon;

  private boolean hasLost;

  private int turn = 0;
  private Board board;
  private Smurf smurf;

  final String difficulty = "Default";

  private PropertyChangeSupport support;

  public Game(Enum difficulty){
    support = new PropertyChangeSupport(this);
    this.board = new Board(support);
    this.smurf=new Smurf(board);
  }


  public Board getBoard() {
    return board;
  }

  public Smurf getSmurf() {
    return smurf;
  }

  public void NewTurn(){
    turn++;
    if (smurf.checkIfWon()) {
      boolean oldValue = hasWon;
      hasWon=true;
      support.firePropertyChange("Won", oldValue, true);
    }
    else {
      smurf.moveSmurf();
      if (smurf.checkIfLost()){
        boolean oldValue = hasLost;
        hasLost=true;
        support.firePropertyChange("Lost", oldValue, true);
      }
    }
  }

  public int getTurn() {
    return turn;
  }

  public boolean isHasWon() {
    return hasWon;
  }

  public boolean isHasLost() {
    return hasLost;
  }


}