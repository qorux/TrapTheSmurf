package main.java.edu.chalmers.projecttemplate.view;

import main.java.edu.chalmers.projecttemplate.model.Board;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonBoard {
    private JPanel jPanel1;
    private Board board;
    private ArrayList<hexButton> buttonBoard = new ArrayList<hexButton>();

    public ButtonBoard(Board board, JPanel jPanel1) {
        this.jPanel1 = jPanel1;
        this.board = board;
        for(int i =0;i<=120;i++){
            buttonBoard.add(generateButton(i));
        }
    }

    public hexButton getButton(int Index) {
        return buttonBoard.get(Index);
    }

    public ArrayList<hexButton> getButtonBoard() {
        return buttonBoard;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    private hexButton generateButton(Integer index){
        hexButton generatedButton = new hexButton(board.getHexagon(index));
        generatedButton.setBackground(Color.cyan);
        generatedButton.setPreferredSize(new Dimension(40,40));
        jPanel1.add(generatedButton);
        jPanel1.add(Box.createRigidArea(new Dimension(8,0)));
        if (index == 10 || index == 32 || index == 54 || index == 76 || index == 98){
            for (int i = 0; i < 4 ; i++) {
                JPanel jPanelMini = new JPanel();
                jPanelMini.setSize(20,40);
                jPanel1.add(jPanelMini);
            }
        }
        return generatedButton;
    }
}
