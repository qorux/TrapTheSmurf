package main.java.edu.chalmers.projecttemplate.view;

import main.java.edu.chalmers.projecttemplate.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class OBoardState implements PropertyChangeListener {

    private ArrayList<hexButton> buttonBoard;
    private ProjectView projectView;
    private Project project;
    private Board hexagonBoard;
    public OBoardState(ProjectView projectView, Project project) {
        this.projectView = projectView;
        this.project = project;
        this.buttonBoard = projectView.getButtonBoard();
        this.hexagonBoard = project.getBoard();
    }


    public void propertyChange(PropertyChangeEvent evt) {

        if(!project.isHasLost() && !project.isHasWon()){
            repaintBoardView();
        }
        else if (Objects.equals(evt.getPropertyName(), "Won")) {//aids
            for (int i = 0; i<121; i++) {
                buttonBoard.get(i).setEnabled(false);
            }
            projectView.getjLabel2().setText("You won the game! You won in " + project.getTurn() + " turns. Press reset to play again");
        }
        else if (Objects.equals(evt.getPropertyName(), "Lost")) {
            for (int i = 0; i<121; i++) {
                buttonBoard.get(i).setEnabled(false);
            }
            projectView.getjLabel2().setText("The Smurf won. It escaped in " + project.getTurn() + " turns. Press reset to play again");
        }
    }

    public void repaintBoardView(){
        projectView.getjLabel2().setText("Number of turns: " + project.getTurn() + " ");
        for(int i = 0; i<121; i++) {
            if (ClickableTile.class.equals(hexagonBoard.getHexagon(i).getCurrentStateClass())&& !buttonBoard.get(i).getIsHovered()){
                buttonBoard.get(i).setBackground(Color.cyan);
                buttonBoard.get(i).setEnabled(true);
            }
            else if (ClickableTile.class.equals(hexagonBoard.getHexagon(i).getCurrentStateClass())&& buttonBoard.get(i).getIsHovered()){
                buttonBoard.get(i).setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
                buttonBoard.get(i).setEnabled(true);
            }
            else if (OccupiedTile.class.equals(hexagonBoard.getHexagon(i).getCurrentStateClass())) {
                buttonBoard.get(i).setBackground(Color.red);
                buttonBoard.get(i).setEnabled(false);
            }
            else if (BlockedTile.class.equals(hexagonBoard.getHexagon(i).getCurrentStateClass())) {
                buttonBoard.get(i).setBackground(Color.darkGray);
                buttonBoard.get(i).setEnabled(false);
            }
        }
    }


/*    public void setSmurfImage(int i) throws MalformedURLException {
        ImageIcon smurf = new ImageIcon(new URL("https://e7.pngegg.com/pngimages/1016/380/png-clipart-sticker-telegram-the-smurfs-text-viber-smurf-area-soccer.png"));
        Image image = smurf.getImage();
        Image smurfImage = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);
        smurf = new ImageIcon(smurfImage);
        buttonBoard.get(i).setIcon(smurf);
    }*/

    // standard getter and setter
}