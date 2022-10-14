package main.java.edu.chalmers.projecttemplate.model;

import main.java.edu.chalmers.projecttemplate.ProjectTemplate;
import main.java.edu.chalmers.projecttemplate.controller.ProjectController;
import main.java.edu.chalmers.projecttemplate.view.ProjectView;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project {
  private boolean hasWon;

  private boolean hasLost;

  private int turn = 0;
  private Board board;
  private Smurf smurf;

  private PropertyChangeSupport support;

  public Project(){
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