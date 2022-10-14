package main.java.edu.chalmers.projecttemplate.model;

public class GameHandler {
    String difficulty = "Default";

    Game currentGame;

    public GameHandler() {
        currentGame = new Game(difficulty);
    }


    public void NewGame(Game game){

    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public Game getCurrentGame() {
        return currentGame;
    }
}
