package main.java.edu.chalmers.projecttemplate.model;

public class Project {
  public static final String PROJECT_WINDOW_TEXT = "ProjectTemplate";
  public static final String PROJECT_BUTTON_TEXT = "Press me!";
  private int presses;
  public Board board;//borde va private

  private Smurf smurf;
  public Project(){
    this.board = new Board();
    this.smurf=new Smurf(board.getBoardSpaces().get(60));
  }


  public Board getBoard() {
    return board;
  }

  public Smurf getSmurf() {
    return smurf;
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
