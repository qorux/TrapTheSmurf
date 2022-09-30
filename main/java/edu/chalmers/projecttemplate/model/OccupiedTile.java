package main.java.edu.chalmers.projecttemplate.model;


public class OccupiedTile implements HexagonState {

    @Override
    public void blockTile() {}

    @Override
    public void clickTile() {
        System.out.println("smurf is on this tile");
    }

    @Override
    public void occupyTile() {
        System.out.println("smurf is on this tile");
    }

}
