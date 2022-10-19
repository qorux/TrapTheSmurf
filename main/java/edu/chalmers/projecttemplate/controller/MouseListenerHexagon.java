package main.java.edu.chalmers.projecttemplate.controller;

import java.awt.*;
import java.awt.event.*;

import main.java.edu.chalmers.projecttemplate.view.HexButton;

public class MouseListenerHexagon extends Frame implements MouseListener {

    public MouseListenerHexagon(){
        addMouseListener(this);
    }

    public void mouseEntered(MouseEvent e) {
        Component c = e.getComponent();
        HexButton hexbutton = (HexButton) c;
        hexbutton.setHovered(true);
    }

    public void mouseExited(MouseEvent e) {
        Component c = e.getComponent();
        HexButton hexbutton = (HexButton) c;
        hexbutton.setHovered(false);
    }

    public void mousePressed(MouseEvent e) {

    }
    public void mouseClicked(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }

}
