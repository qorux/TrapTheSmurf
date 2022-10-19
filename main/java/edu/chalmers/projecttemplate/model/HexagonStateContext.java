package main.java.edu.chalmers.projecttemplate.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HexagonStateContext {

    private PropertyChangeSupport support;
    private HexagonState currentState;

    Hexagon hexagon;

    public HexagonStateContext(Hexagon Hexagon, PropertyChangeSupport Support) {
        this.support = Support;
        this.hexagon = Hexagon;
        currentState = new FreeTile(hexagon);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setHexagonState(HexagonState newstate) {
        currentState = newstate;
        support.firePropertyChange("Hexagonstate", hexagon, newstate);
    }

    public HexagonState getCurrentState() {
        return currentState;
    }

    public void occupy(){
        currentState.occupyTile();
        setHexagonState(new OccupiedTile());
    }

    public void block(){
        currentState.blockTile();
        setHexagonState(new BlockedTile());

    }

    public void makeFree() {
        setHexagonState(new FreeTile(hexagon));
    }
}
