package main.java.edu.chalmers.projecttemplate.controller;

import java.awt.*;
import java.awt.event.*;

import main.java.edu.chalmers.projecttemplate.view.HexButton;

public class MouseListenerHexagon extends Frame implements MouseListener {

    public MouseListenerHexagon(){
        addMouseListener(this);
    }

    public void mouseEntered(final MouseEvent event) {
        final Component c = event.getComponent();
        final HexButton hexbutton = (HexButton) c;
        hexbutton.setHovered(true);
    }

    public void mouseExited(final MouseEvent event) {
        final Component c = event.getComponent();
        final HexButton hexbutton = (HexButton) c;
        hexbutton.setHovered(false);
    }

    public void mousePressed(final MouseEvent event) {

    }
    public void mouseClicked(final MouseEvent event) {

    }
    public void mouseReleased(final MouseEvent event) {

    }

}
