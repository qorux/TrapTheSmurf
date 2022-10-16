package main.java.edu.chalmers.projecttemplate.model;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Hexagon{
    private HexagonStateContext wrapper;
    private Integer index;
    private PropertyChangeSupport support;


    public Hexagon(Integer boardIndex, PropertyChangeSupport Support) {
        this.support = Support;
        this.index= boardIndex;
        this.wrapper = new HexagonStateContext(this,support);
    }

    public HexagonStateContext getHexagonStateContext() {
        return wrapper;
    }


    public void occupyTile() {
        wrapper.occupy();
    }

    public void blockTile() {
        wrapper.block();
    }

    public void makeClickable() {
        wrapper.makeClickable();
    }

    public Class<? extends HexagonState> getCurrentStateClass(){
        return this.getHexagonStateContext().getCurrentState().getClass();
    }


    public Integer getIndex() {
        return index;
    }

    public PropertyChangeSupport getSupport() {
        return support;
    }

}
