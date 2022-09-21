package main.java.edu.chalmers.projecttemplate.model;

import javax.swing.*;
import main.java.edu.chalmers.projecttemplate.view.*;

public class HexagonStateContext {
    private HexagonState currentState;

    private Integer index;
    private myFirstForm projectView;

    public HexagonStateContext(Integer Index, myFirstForm ProjectView) {
        this.index = Index;
        this.projectView = ProjectView;
        currentState = new ClickableTile(index, projectView);
    }


    public HexagonState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(HexagonState currentState) {
        this.currentState = currentState;
    }

    public void click(){
        currentState.clickTile();
        setCurrentState(new BlockedTile(index, projectView));
    }

    public void occupy(){
        currentState.occupyTile();
        setCurrentState(new OccupiedTile(index, projectView));
    }
}
