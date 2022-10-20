package main.java.edu.chalmers.projecttemplate.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Responsibility: the different states the hexagons can
 * assume, declaring them as enums.
 * Uses: -
 * Used by: Board, Smurf, HexButton
 */
public class Hexagon{
    private State currentState = State.FREE;
    public enum State {
        BLOCKED,
        FREE,
        OCCUPIED
    }
    private final Integer index;
    private final PropertyChangeSupport support;


    public Hexagon(final Integer boardIndex, final PropertyChangeSupport support) {
        this.support = support;
        this.index= boardIndex;
    }

    public void setHexagonState(final State newState) {
        final State oldState = currentState;
        currentState = newState;
        support.firePropertyChange("Hexagonstate", oldState, newState);
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
