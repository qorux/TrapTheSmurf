package main.java.model;
import java.beans.PropertyChangeSupport;

/**
 * Sets up the game with a board and a smurf.
 * Also handles the turns and checks if the game is won or lost.
 */
public class Game {
  private boolean hasWon;

  private boolean hasLost;

  private int turn;
  private final Board board;
  private final Smurf smurf;

  private final PropertyChangeSupport support;

  public Game(){
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

  /**
   * Checks whether the game is won, if not the smurf makes
   * it move, and then checks if the game is lost.
   * Also increments the turn variable, which is used to keep
   * track of how many turns it takes to win or lose.
   */
  public void newTurn(){
    turn++;
    if (smurf.checkIfWon()) {
      final boolean oldValue = hasWon;
      hasWon=true;
      support.firePropertyChange("Won", oldValue, true);
    }
    else {
      smurf.moveSmurf();
      if (smurf.checkIfLost()){
        final boolean oldValue = hasLost;
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