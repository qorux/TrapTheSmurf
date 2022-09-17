package main.java.edu.chalmers.projecttemplate.model;

public class ClickableTile implements HexagonState {

    Hexagon hexagon;

    public ClickableTile(Hexagon newHexagon){
        hexagon = newHexagon;
    }

    @Override
    public void blockTile() {

    }

    @Override
    public void occupyTile() {

    }

    @Override
    public void freeTile() {

    }
}
