package main.java.edu.chalmers.projecttemplate.model;

import java.util.ArrayList;

public class Board {
    private ArrayList <Hexagon> boardSpaces ;

    public Board(){
        boardSpaces = new ArrayList<Hexagon>();
        for(int i=0;i<=5;i++){
            boardSpaces.add(new Hexagon());
        }
    }

    public ArrayList<Hexagon> getBoardSpaces() {
        return boardSpaces;
    }
}

