package main.java.edu.chalmers.projecttemplate.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Hexagon{
    private State currentState = State.FREE;
    public enum State {
        BLOCKED,
        FREE,
        OCCUPIED
    }
    private final Integer index;
    private final PropertyChangeSupport support;


    public Hexagon(Integer boardIndex, PropertyChangeSupport support) {
        this.support = support;
        this.index= boardIndex;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setHexagonState(State newstate) {
        State oldState = currentState;
        currentState = newstate;
        support.firePropertyChange("Hexagonstate", oldState, newstate);
    }

    public State getCurrentState() {
        return currentState;
    }

    public Integer getIndex() {
        return index;
    }

    public PropertyChangeSupport getSupport() {
        return support;
    }

}
