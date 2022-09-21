package main.java.edu.chalmers.projecttemplate.model;


import javax.swing.*;
import main.java.edu.chalmers.projecttemplate.view.*;

import java.awt.*;

public class OccupiedTile implements HexagonState {

    myFirstForm projectView;
    Integer Index;
    JButton tile;
    public OccupiedTile(Integer index, myFirstForm ProjectView) {
        this.projectView = ProjectView;
        this.Index = index;
        this.tile = ProjectView.getButtonBoard().get(Index);
    }

    @Override
    public void clickTile() {
        System.out.println("Occupied Tile ignores input");
    }

    @Override
    public void occupyTile() {

    }

}
