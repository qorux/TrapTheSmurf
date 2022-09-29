package main.java.edu.chalmers.projecttemplate.model;

import java.util.ArrayList;
import main.java.edu.chalmers.projecttemplate.view.*;

public class Board {
    private ArrayList <Hexagon> boardSpaces ;

    public Board(){
        boardSpaces = new ArrayList<Hexagon>();
        for(int i=0;i<=120;i++){
            boardSpaces.add(new Hexagon(i));
        }
    }

    public ArrayList<Hexagon> getBoardSpaces() {
        return boardSpaces;
    }
}

