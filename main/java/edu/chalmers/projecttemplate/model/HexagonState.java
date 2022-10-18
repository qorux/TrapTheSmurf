package main.java.edu.chalmers.projecttemplate.model;

import javax.swing.*;
import java.awt.*;

/**
 * Interface for the design pattern "state pattern". There are three different states the hexagons
 * can assume throughout the game:
 * BlockedTile - tiles that cannot be interacted with
 * OccupiedTile - tile that the smurf is currently on, cannot be interacted with by the user
 * ClickableTile - free to be blocked by the user or occupied by the smurf
 */
public interface HexagonState{
    public void clickTile();
    public void occupyTile();
    public void blockTile();


}
