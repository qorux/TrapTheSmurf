package main.java.edu.chalmers.projecttemplate.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

/**
 * Handles the information that needs to be saved when the game
 * is reset or closed, such as difficulties and statistics of played games.
 */
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


    /**
     * Saves the stats of the current game, then creates a new one.
     */

    public void newGame(){
        if (getCurrentGame().isHasWon() || getCurrentGame().isHasLost()) {
            saveStats();
        }
        currentGame = new Game();
    }

    private void saveStats() {
        try {
            final FileWriter fileWriter = generateFileWriter();

            final BufferedWriter writer = new BufferedWriter(fileWriter);

            final int turnsToWin = getCurrentGame().getTurn();

            writer.write(getCurrentGame().isHasWon() + " ");
            writer.write(Integer.toString(turnsToWin));
            writer.write("\n");
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
            //e.printStackTrace();
            //System.exit(1);
        }
        readStats();
    }

    private void readStats() { //Lite väl lång men men
        final File file = new File(getPath());
        totalWins = 0;
        totalLosses = 0;
        try {
            final BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            recordTurns = Integer.MAX_VALUE;
            if (file.length() > 0) {
                while ((line = reader.readLine()) != null) {
                    try {
                        final String[] tokens = line.split(" ");
                        final int number = Integer.parseInt(tokens[1]);
                        final String outcome = tokens[0];

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
            throw new RuntimeException(e);
            //e.printStackTrace();
            //System.exit(1);
        }
    }

    private FileWriter generateFileWriter() {
        final File file = new File(getPath());
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file,true); }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);}
        return fileWriter;
    }

    private String getPath() {
        final Path path = Paths.get("main\\Resources\\TrapTheSmurfStats.txt");
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

    public void setDifficulty(final Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

}
