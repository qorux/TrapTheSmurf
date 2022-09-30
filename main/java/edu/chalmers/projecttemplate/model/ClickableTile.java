package main.java.edu.chalmers.projecttemplate.model;


public class ClickableTile implements HexagonState {

    private Hexagon hexagon;
    public ClickableTile(Hexagon Hexagon) {
        this.hexagon = Hexagon;
    }

    @Override
    public void clickTile() {
    }


    @Override
    public void occupyTile() {

    }
    @Override
    public void blockTile() {}

}
