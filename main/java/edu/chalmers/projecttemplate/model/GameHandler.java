package main.java.edu.chalmers.projecttemplate.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

public class GameHandler {
    private Difficulty difficulty = Difficulty.DEFAULT;

    public enum Difficulty {
        EASY,
        MEDIUM,
        HARD,
        DEFAULT
    }
    private Game currentGame;

    private int totalWins;

    private int totalLosses;

    private int recordTurns;

    public GameHandler() {
        currentGame = new Game();
        readStats();
    }


    public void newGame(){
        if (getCurrentGame().isHasWon() || getCurrentGame().isHasLost()) {
            saveStats();
        }
        currentGame = new Game();
    }

    private void saveStats() {
        try {
            FileWriter fw = generateFileWriter();

            BufferedWriter writer = new BufferedWriter(fw);

            int turnsToWin = getCurrentGame().getTurn();

            writer.write(getCurrentGame().isHasWon() + " ");
            writer.write(Integer.toString(turnsToWin));
            writer.write("\n");
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        readStats();
    }

    private void readStats() { //Lite väl lång men men
        File file = new File(getPath());
        totalWins = 0;
        totalLosses = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            recordTurns = Integer.MAX_VALUE;
            if (file.length() > 0) {
                while ((line = reader.readLine()) != null) {
                    try {
                        String[] tokens = line.split(" ");
                        int number = Integer.parseInt(tokens[1]);
                        String outcome = tokens[0];

                        if ("true".equals(outcome)) {
                            recordTurns = Math.min(number, recordTurns);
                            totalWins++;
                        } else if ("false".equals(outcome)) {
                            totalLosses++;
                        }
                    }
                    catch (NumberFormatException ex) {
                        throw new FileNotFoundException();
                    }
                }
            }
            else {
                recordTurns = 0;
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException();
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
        Path path = Paths.get("main\\Resources\\TrapTheSmurfStats.txt");
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

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

}
