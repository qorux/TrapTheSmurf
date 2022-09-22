package main.java.edu.chalmers.projecttemplate.model;
import main.java.edu.chalmers.projecttemplate.view.*;

public class Hexagon{
    private HexagonStateContext hexagonStateContext;
    private Integer index;

    private myFirstForm projectView;

    public Hexagon(Integer boardIndex) {
        this.index= boardIndex;
        this.hexagonStateContext = new HexagonStateContext(index);
    }

    public HexagonStateContext getHexagonStateContext() {
        return hexagonStateContext;
    }

    void setHexagonState(HexagonState newHexagonState){
        hexagonStateContext.setCurrentState(newHexagonState);
    }

    public void clickTile() {
        hexagonStateContext.click();
    }

    public void occupyTile() {
        hexagonStateContext.occupy();
    }




}
