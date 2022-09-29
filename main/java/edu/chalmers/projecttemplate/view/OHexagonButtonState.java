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
        System.out.print("Observer saw changed state. State: ");
        System.out.println(currentState.getClass());
        if (OccupiedTile.class.equals(currentState.getClass())){
            buttonBoard.get(currentState.getIndex()).setBackground(Color.RED);
            buttonBoard.get(currentState.getIndex()).setEnabled(false);

            System.out.println("röd!");
        }
        if (BlockedTile.class.equals(currentState.getClass())){
            buttonBoard.get(currentState.getIndex()).setBackground(Color.DARK_GRAY);
            buttonBoard.get(currentState.getIndex()).setEnabled(false);
        }
    }

    // standard getter and setter
}