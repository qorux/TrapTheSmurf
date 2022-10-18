package main.java.edu.chalmers.projecttemplate.model;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GameHandler {
    private Game game;
    String difficulty = "Default";

    Game currentGame;

    int totalWins;

    int totalLosses;

    int recordTurns;

    public GameHandler() {
        currentGame = new Game(difficulty);
    }


    public void NewGame(){
        if (getCurrentGame().isHasWon() || getCurrentGame().isHasLost()) {
            saveStats();
            System.out.println("Total losses: " + totalLosses);
            System.out.println("Total wins: " + totalWins);
        }
        currentGame = new Game(difficulty);
    }

    private void saveStats() {
        try {
            FileWriter fw = generateFileWriter();

            BufferedWriter writer = new BufferedWriter(fw);

            int turnsToWin = getCurrentGame().getTurn();

            writer.write(String.valueOf(getCurrentGame().isHasWon()) + " ");
            writer.write(Integer.toString(turnsToWin));
            writer.write("\n");
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        readStats();
    }

    private void readStats() {
        File file = new File(getPath());
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            recordTurns = Integer.MAX_VALUE;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] tokens = line.split(" ");
                    int number = Integer.parseInt(tokens[1]);
                    String outcome = tokens[0];

                    if (outcome.equals("true")) {
                        recordTurns = Math.min(number, recordTurns);
                    totalWins++;
                    }
                    else if (outcome.equals("false")) {
                       totalLosses++;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("No more saved games to check");
                }
            }
            reader.close();
            System.out.println("Best no. of turns is: " + recordTurns);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private FileWriter generateFileWriter() {
        File file = new File(getPath());
        FileWriter fw;
        try {
            fw = new FileWriter(file,true); }
        catch (IOException e) {
            throw new RuntimeException(e);}
        return fw;
    }

    private String getPath() {
        Path path = Paths.get("TrapTheSmurfStats.txt");
        return path.toString();
    }

    public int getTotalWins() {
        return totalWins;
    }

    public int getTotalLosses() {
        return totalLosses;
    }

    public int getRecordTurns() {
        return recordTurns;
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
