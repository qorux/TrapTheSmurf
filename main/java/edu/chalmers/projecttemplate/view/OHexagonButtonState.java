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
        projectView.getjLabel2().setText("Number of turns: " + project.getTurn() + " ");
        for(int i = 0; i<121; i++) {
        if (ClickableTile.class.equals(project.board.getHexagon(i).getHexagonStateContext().getCurrentState().getClass())){
            buttonBoard.get(i).setBackground(Color.cyan);
            buttonBoard.get(i).setEnabled(true);
        }
        else if (OccupiedTile.class.equals(project.board.getHexagon(i).getHexagonStateContext().getCurrentState().getClass())) {
            buttonBoard.get(i).setBackground(Color.red);
            buttonBoard.get(i).setEnabled(false);
        }
        else if (BlockedTile.class.equals(project.board.getHexagon(i).getHexagonStateContext().getCurrentState().getClass())) {
            buttonBoard.get(i).setBackground(Color.darkGray);
            buttonBoard.get(i).setEnabled(false);
        }
        }
        if (project.hasWon) {
            for (int i = 0; i<121; i++) {
                buttonBoard.get(i).setEnabled(false);
                projectView.getjLabel2().setText("You won the game! You won in " + project.getTurn() + " turns. Press reset to play again");
            }
        }
    }
    // standard getter and setter
}