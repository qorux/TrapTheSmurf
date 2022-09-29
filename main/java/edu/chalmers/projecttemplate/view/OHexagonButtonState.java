package main.java.edu.chalmers.projecttemplate.view;

import main.java.edu.chalmers.projecttemplate.model.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
public class OHexagonButtonState implements Observer {

    private ArrayList<hexButton> buttonBoard;
    public OHexagonButtonState(ArrayList<hexButton> ButtonBoard) {
        this.buttonBoard = ButtonBoard;
    }

    @Override
    public void update(Observable o, Object CurrentState) {
        HexagonState currentState = (HexagonState) CurrentState;
        if (OccupiedTile.class.equals(currentState.getClass())){
            buttonBoard.get(currentState.getIndex()).setBackground(Color.RED);
            buttonBoard.get(currentState.getIndex()).setEnabled(false);
        }
        if (BlockedTile.class.equals(currentState.getClass())){
            buttonBoard.get(currentState.getIndex()).setBackground(Color.DARK_GRAY);
            buttonBoard.get(currentState.getIndex()).setEnabled(false);
        }
        if (ClickableTile.class.equals(currentState.getClass())){
            buttonBoard.get(currentState.getIndex()).setBackground(Color.CYAN);
            buttonBoard.get(currentState.getIndex()).setEnabled(true);
        }
    }

    // standard getter and setter
}