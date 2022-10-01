package main.java.edu.chalmers.projecttemplate.model;

import java.beans.PropertyChangeSupport;

public class Hexagon{
    private HexagonStateContext wrapper;
    private Integer index;

    private PropertyChangeSupport support;

    public PropertyChangeSupport getSupport() {
        return support;
    }

    public Hexagon(Integer boardIndex, PropertyChangeSupport Support) {
        this.support = Support;
        this.index= boardIndex;
        this.wrapper = new HexagonStateContext(this,support);

    }

    public HexagonStateContext getHexagonStateContext() {
        return wrapper;
    }


    public void clickTile() {
        wrapper.click();
    }

    public void occupyTile() {
        wrapper.occupy();
    }

    public void blockTile() {
        wrapper.block();
    }


    public Integer getIndex() {
        return index;
    }


}
