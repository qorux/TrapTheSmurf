package main.java.edu.chalmers.projecttemplate.model;

import main.java.edu.chalmers.projecttemplate.view.*;

public class HexagonStateContext {
    private HexagonState currentState;

    private Integer index;

    public HexagonStateContext(Integer Index) {
        this.index = Index;
        currentState = new ClickableTile();
    }


    public HexagonState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(HexagonState currentState) {
        this.currentState = currentState;
    }

    public void click(){
        currentState.clickTile();
        setCurrentState(new BlockedTile());
    }

    public void occupy(){
        currentState.occupyTile();
        setCurrentState(new OccupiedTile());
    }
}
