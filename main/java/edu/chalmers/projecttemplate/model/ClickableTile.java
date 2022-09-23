package main.java.edu.chalmers.projecttemplate.model;


import javax.swing.*;
import main.java.edu.chalmers.projecttemplate.view.*;

import java.awt.*;

public class ClickableTile implements HexagonState {

    Integer Index;

    public ClickableTile(Integer index) {
        this.Index = index;
    }

    @Override
    public void clickTile() {
        System.out.println("Clickable tile turns gray");
    }

    public Integer getIndex() {
        return Index;
    }

    @Override
    public void occupyTile() {

    }

}
