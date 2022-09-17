package main.java.edu.chalmers.projecttemplate.model;

public class BlockedTile implements HexagonState {

    Hexagon hexagon;

    public BlockedTile(Hexagon newHexagon){
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
