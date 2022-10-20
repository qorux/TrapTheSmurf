package test.java.edu.chalmers.projecttemplate.model;

import main.java.edu.chalmers.projecttemplate.model.Game;
import main.java.edu.chalmers.projecttemplate.model.GameHandler;
import main.java.edu.chalmers.projecttemplate.model.Hexagon;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class GameHandlerTest {

    @Test
    void newGame() {
        GameHandler gameHandler = new GameHandler();
        Game game = gameHandler.getCurrentGame();
        for (int i = 0; i<5; i++) {
        game.newTurn(); }
        assertTrue(game.isHasLost());

        gameHandler.newGame();
        String file = Paths.get("main\\Resources\\TrapTheSmurfStats.txt").toString();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String sCurrentLine;
            String lastLine = "";
            while ((sCurrentLine = reader.readLine()) != null) {
                lastLine = sCurrentLine;
            }
            assertEquals(lastLine, "false 5");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getTotalWins() {
        GameHandler gameHandler = new GameHandler();
        int wins = gameHandler.getTotalWins();
        assertEquals(gameHandler.getTotalWins(), wins);
    }

    @Test
    void getTotalLosses() {
        GameHandler gameHandler = new GameHandler();
        int losses = gameHandler.getTotalLosses();
        assertEquals(gameHandler.getTotalLosses(), losses);
    }

    @Test
    void getRecordTurns() {
        GameHandler gameHandler = new GameHandler();
        int record = gameHandler.getRecordTurns();
        assertEquals(gameHandler.getRecordTurns(), record);
    }

    @Test
    void setDifficulty() {
        GameHandler gameHandler = new GameHandler();
        GameHandler.Difficulty difficulty = gameHandler.getDifficulty();
        assertEquals(difficulty, GameHandler.Difficulty.DEFAULT);
        gameHandler.setDifficulty(GameHandler.Difficulty.HARD);
        assertEquals(gameHandler.getDifficulty(), GameHandler.Difficulty.HARD);
    }

    @Test
    void getDifficulty() {
        GameHandler gameHandler = new GameHandler();
        GameHandler.Difficulty difficulty = gameHandler.getDifficulty();
        assertEquals(gameHandler.getDifficulty(), difficulty);
    }

    @Test
    void getCurrentGame() {
        GameHandler gameHandler = new GameHandler();
        Game game = gameHandler.getCurrentGame();
        assertEquals(gameHandler.getCurrentGame(), game);
    }
}