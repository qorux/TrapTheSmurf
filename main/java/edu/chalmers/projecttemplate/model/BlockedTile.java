package main.java.edu.chalmers.projecttemplate.model;


import javax.swing.*;
import main.java.edu.chalmers.projecttemplate.view.*;

import java.awt.*;

public class BlockedTile implements HexagonState {

    public BlockedTile() {
    }

    @Override
    public void clickTile() {
        System.out.println("Blocked tile ignores input");
    }

    @Override
    public void occupyTile() {

    }

}
