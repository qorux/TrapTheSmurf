package main.java.edu.chalmers.projecttemplate.model;
import main.java.edu.chalmers.projecttemplate.view.*;

public class Project {
  public static final String PROJECT_WINDOW_TEXT = "ProjectTemplate";
  public static final String PROJECT_BUTTON_TEXT = "Press me!";
  private int presses;
  public Board board;//borde va private
  public Project(myFirstForm ProjectView){
    this.board = new Board(ProjectView);
  }


  public int getPresses() {
    int bla;
    bla = 42;
    return presses;
  }

  public Hexagon getTile(Integer index) {
    return board.getBoardSpaces().get(index);
  }

  public void incrementPresses() {
    this.presses++;
  }
}
