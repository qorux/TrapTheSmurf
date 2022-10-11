package main.java.edu.chalmers.projecttemplate.view;

import main.java.edu.chalmers.projecttemplate.model.*;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class OHexagonButtonState implements PropertyChangeListener {

    private ArrayList<hexButton> buttonBoard;
    private ProjectView projectView;
    private Project project;
    private Board hexagonBoard;
    public OHexagonButtonState(ArrayList<hexButton> ButtonBoard, Board HexagonBoard, ProjectView projectView, Project project) {
        this.buttonBoard = ButtonBoard;
        this.hexagonBoard = HexagonBoard;
        this.projectView = projectView;
        this.project = project;
    }


    public void propertyChange(PropertyChangeEvent evt) {

        //repaint all components every time
        Hexagon hexagon = ((Hexagon)evt.getOldValue());
        int pressedTileIndex = hexagon.getIndex();
        projectView.getjLabel2().setText("Number of turns: " + project.getTurn() + " ");

        //stor bugg, clickabletile och blockedtile har bytit plats
        if (ClickableTile.class.equals(hexagon.getHexagonStateContext().getCurrentState().getClass())){
            buttonBoard.get(pressedTileIndex).setBackground(Color.cyan);
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