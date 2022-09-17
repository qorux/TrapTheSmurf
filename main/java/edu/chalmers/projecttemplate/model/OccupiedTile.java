package main.java.edu.chalmers.projecttemplate.model;

public class OccupiedTile implements HexagonState {

    Hexagon hexagon;

    public OccupiedTile(Hexagon newHexagon){
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
