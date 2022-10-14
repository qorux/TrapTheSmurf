package main.java.edu.chalmers.projecttemplate.controller;

import java.awt.*;
import java.awt.event.*;

import main.java.edu.chalmers.projecttemplate.view.hexButton;

public class MouseListenerHexagon extends Frame implements MouseListener {

    MouseListenerHexagon(){
        addMouseListener(this);
    }

    public void mouseEntered(MouseEvent e) {
        Component c = e.getComponent();
        hexButton hexbutton = (hexButton) c;
        hexbutton.setHovered(true);
    }

    public void mouseExited(MouseEvent e) {
        Component c = e.getComponent();
        hexButton hexbutton = (hexButton) c;
        hexbutton.setHovered(false);
    }

    public void mousePressed(MouseEvent e) {

    }
    public void mouseClicked(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }

}
