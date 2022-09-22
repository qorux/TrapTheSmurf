package main.java.edu.chalmers.projecttemplate.model;

import java.util.ArrayList;
import main.java.edu.chalmers.projecttemplate.view.*;

public class Board {
    private ArrayList <Hexagon> boardSpaces ;

    myFirstForm projectView;

    public Board(myFirstForm ProjectView){
        boardSpaces = new ArrayList<Hexagon>();
        this.projectView = ProjectView;
        for(int i=0;i<=10;i++){
            boardSpaces.add(new Hexagon(i, projectView));
        }
    }

    public ArrayList<Hexagon> getBoardSpaces() {
        return boardSpaces;
    }
}

