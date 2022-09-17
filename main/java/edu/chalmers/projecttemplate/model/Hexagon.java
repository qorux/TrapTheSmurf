package main.java.edu.chalmers.projecttemplate.model;

public class Hexagon {

    private Boolean State = true;

    public void switchState(){
        System.out.println("Hexagon switched state");
    }

    HexagonState blockedTile;
    HexagonState occupiedTile;
    HexagonState clickableTile;

    HexagonState hexagonState;

    public Hexagon(){
        blockedTile = new BlockedTile(this);
        occupiedTile = new OccupiedTile(this);
        clickableTile = new ClickableTile(this);

        hexagonState = clickableTile;

    }

    void setHexagonState(HexagonState newHexagonState){
        hexagonState = newHexagonState;
    }

    public void blockTile() {
        hexagonState.blockTile();
    }

    public void occupyTile() {
        hexagonState.occupyTile();
    }

    public void freeTile() {
        hexagonState.freeTile();
    }

}
