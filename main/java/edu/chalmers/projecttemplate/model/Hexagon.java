package main.java.edu.chalmers.projecttemplate.model;
import main.java.edu.chalmers.projecttemplate.view.*;

public class Hexagon{
    private OHexagonStateContext observable;
    private Integer index;

    private myFirstForm projectView;

    public Hexagon(Integer boardIndex) {
        this.index= boardIndex;
        this.observable = new OHexagonStateContext(index);

    }

    public OHexagonStateContext getHexagonStateContext() {
        return observable;
    }

    public void setHexagonState(HexagonState newHexagonState){
        observable.setCurrentState(newHexagonState);
    }

    public void clickTile() {
        observable.click();
    }

    public void occupyTile() {
        observable.occupy();
    }


    public Integer getIndex() {
        return index;
    }


}
