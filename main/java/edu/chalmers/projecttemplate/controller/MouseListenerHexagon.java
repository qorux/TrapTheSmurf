package main.java.edu.chalmers.projecttemplate.controller;

import java.awt.*;
import java.awt.event.*;

import main.java.edu.chalmers.projecttemplate.model.ClickableTile;
import main.java.edu.chalmers.projecttemplate.model.Hexagon;
import main.java.edu.chalmers.projecttemplate.model.Project;
import main.java.edu.chalmers.projecttemplate.model.OccupiedTile;
import main.java.edu.chalmers.projecttemplate.view.ProjectView;

public class MouseListenerHexagon extends Frame implements MouseListener {

    Project project = new Project();
    ProjectView ProjectView = new ProjectView(project);
    MouseListenerHexagon(Project project, ProjectView projectView){
        addMouseListener(this);

    }

    public void mouseEntered(MouseEvent e) {
        Component c = e.getComponent();
        c.setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
    }

    public void mouseExited(MouseEvent e) {
        Component c = e.getComponent();
        c.setBackground(Color.CYAN);
    }

    public void mousePressed(MouseEvent e) {

    }
    public void mouseClicked(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }
}
