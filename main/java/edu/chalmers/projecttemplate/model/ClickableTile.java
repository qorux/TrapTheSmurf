package main.java.edu.chalmers.projecttemplate.model;


import javax.swing.*;
import main.java.edu.chalmers.projecttemplate.view.*;

import java.awt.*;

public class ClickableTile implements HexagonState {

    myFirstForm projectView;
    Integer Index;
    JButton tile;
    public ClickableTile(Integer index, myFirstForm ProjectView) {
        this.projectView = ProjectView;
        this.Index = index;
        this.tile = ProjectView.getButtonBoard().get(Index);
    }

    @Override
    public void clickTile() {
        System.out.println("Clickable tile turns gray");
        tile.setBackground(Color.DARK_GRAY);
        tile.setEnabled(false);
    }

    @Override
    public void occupyTile() {

    }

}
