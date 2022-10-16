package main.java.edu.chalmers.projecttemplate.model;

import java.io.*;

public class GameHandler {
    private Game game;
    String difficulty = "Default";

    Game currentGame;

    public GameHandler() {
        currentGame = new Game(difficulty);
    }


    public void NewGame(){
        if (getCurrentGame().isHasWon()) {
            saveTurnsToWin();
        }
        currentGame = new Game(difficulty);
    }

    public void saveTurnsToWin() {
        try {
            File file = getFile();
            FileWriter fw;
            if (file.exists()) {
                fw = new FileWriter(file,true); }
            else {
                file.createNewFile();
                fw = new FileWriter(file); }

            BufferedWriter writer = new BufferedWriter(fw);

            int turnsToWin = getCurrentGame().getTurn();

            writer.write("\n");
            writer.write(Integer.toString(turnsToWin));
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getBestGame();
    }

    public int getBestGame() {
        int lowestNumber = Integer.MAX_VALUE;
        File file = getFile();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int number;
            while ((line = reader.readLine()) != null) {
                try {
                    number = Integer.parseInt(line);
                    lowestNumber = Math.min(number, lowestNumber);
                } catch (NumberFormatException ex) {
                    System.out.println("No more saved games to check");
                }
            }
            reader.close();
            System.out.println("Best no. of turns is: " + lowestNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lowestNumber;
    }

    private File getFile() {
        File file = new File("C:\\TrapTheSmurf\\main\\java\\edu\\chalmers\\projecttemplate", "Stats.txt");
        return file;
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
