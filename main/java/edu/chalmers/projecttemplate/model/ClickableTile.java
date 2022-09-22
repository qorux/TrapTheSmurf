package main.java.edu.chalmers.projecttemplate.model;


import javax.swing.*;
import main.java.edu.chalmers.projecttemplate.view.*;

import java.awt.*;

public class ClickableTile implements HexagonState {

    Integer Index;

    public ClickableTile() {
    }

    @Override
    public void clickTile() {
        System.out.println("Clickable tile turns gray");
    }

    @Override
    public void occupyTile() {

    }

}
