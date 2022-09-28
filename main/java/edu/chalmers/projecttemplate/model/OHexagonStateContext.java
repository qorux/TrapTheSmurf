package main.java.edu.chalmers.projecttemplate.model;

import java.util.Observable;
public class OHexagonStateContext extends Observable{
    private HexagonState currentState;
    private Integer index;

    public OHexagonStateContext(Integer Index) {
        this.index = Index;
        currentState = new ClickableTile(index);
    }

    public Integer getIndex() {
        return index;
    }

    public HexagonState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(HexagonState currentState) {
        this.currentState = currentState;
        setChanged();
        notifyObservers(currentState);
    }

    public void click(){
        currentState.clickTile();
        setCurrentState(new BlockedTile(index));
    }

    public void occupy(){
        currentState.occupyTile();
        setCurrentState(new OccupiedTile(index));
    }

    public void block(){
        currentState.blockTile();
        setCurrentState(new BlockedTile(index));
    }
}
