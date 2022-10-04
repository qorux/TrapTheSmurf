package main.java.edu.chalmers.projecttemplate.view;

import main.java.edu.chalmers.projecttemplate.model.*;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;

public class OHexagonButtonState implements PropertyChangeListener {

    private ArrayList<hexButton> buttonBoard;
    private Board hexagonBoard;
    public OHexagonButtonState(ArrayList<hexButton> ButtonBoard, Board HexagonBoard) {
        this.buttonBoard = ButtonBoard;
        this.hexagonBoard = HexagonBoard;
    }


    public void propertyChange(PropertyChangeEvent evt) {

        Hexagon hexagon = ((Hexagon)evt.getOldValue());
        int pressedTileIndex = hexagon.getIndex();
        System.out.println("Pressed tile index in view: " +pressedTileIndex);


        //stor bugg, clickabletile och blockedtile har bytit plats
        if (ClickableTile.class.equals(hexagon.getHexagonStateContext().getCurrentState().getClass())){
            buttonBoard.get(pressedTileIndex).setBackground(Color.darkGray);
            buttonBoard.get(pressedTileIndex).setEnabled(true);
        }
        else if (OccupiedTile.class.equals(hexagon.getHexagonStateContext().getCurrentState().getClass())){
            buttonBoard.get(pressedTileIndex).setBackground(Color.red);
            buttonBoard.get(pressedTileIndex).setEnabled(false);
        }
        else if (BlockedTile.class.equals(hexagon.getHexagonStateContext().getCurrentState().getClass())){
            buttonBoard.get(pressedTileIndex).setBackground(Color.darkGray);
            buttonBoard.get(pressedTileIndex).setEnabled(false);
        }
    }
    // standard getter and setter
}