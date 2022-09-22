package main.java.edu.chalmers.projecttemplate.model;


import javax.swing.*;
import main.java.edu.chalmers.projecttemplate.view.*;

import java.awt.*;

public class OccupiedTile implements HexagonState {

    public OccupiedTile() {
    }

    @Override
    public void clickTile() {
        System.out.println("smurf is on this tile");
    }

    @Override
    public void occupyTile() {
        System.out.println("smurf is on this tile");
    }

}
