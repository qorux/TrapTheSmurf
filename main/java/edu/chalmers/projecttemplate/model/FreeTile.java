package main.java.edu.chalmers.projecttemplate.model;


public class FreeTile implements HexagonState {

    private Hexagon hexagon;
    public FreeTile(Hexagon Hexagon) {
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
