package main.java.edu.chalmers.projecttemplate.model;


import javax.swing.*;
import main.java.edu.chalmers.projecttemplate.view.*;

import java.awt.*;

public class BlockedTile implements HexagonState {

    Integer index;
    public BlockedTile(Integer Index) {
        this.index=Index;
    }

    @Override
    public Integer getIndex() {
        return index;
    }

    @Override
    public void clickTile() {

    }

    @Override
    public void occupyTile() {

    }

}
