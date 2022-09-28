package main.java.edu.chalmers.projecttemplate.view;

import main.java.edu.chalmers.projecttemplate.model.Hexagon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class hexButton extends JButton {
    Polygon hexagonalShape;
    Hexagon hexagon;

    public hexButton(Hexagon Hexagon) {
        this.setOpaque(false);
        hexagonalShape = getHexPolygon();
        this.hexagon = Hexagon;
    }

    /**
     * Generates a hexagon button instead of default button (square).
     */
    private Polygon getHexPolygon() {
        Polygon hex = new Polygon();
        int w = getWidth() - 1;
        int h = getHeight() - 1;
        int ratio = (int) (h * .25);

        hex.addPoint(w / 2, 0);
        hex.addPoint(w, ratio);
        hex.addPoint(w, h - ratio);
        hex.addPoint(w / 2, h);
        hex.addPoint(0, h - ratio);
        hex.addPoint(0, ratio);

        return hex;
    }

    private void makeBlocked(){
        System.out.println("Blocked hexagon button");
    }

    @Override
    public boolean contains(Point p) {
        return hexagonalShape.contains(p);
    }


    @Override
    public boolean contains(int x, int y) {
        return hexagonalShape.contains(x, y);
    }


    @Override
    public void setSize(Dimension d) {
        super.setSize(d);
        hexagonalShape = getHexPolygon();
    }

    @Override
    public void setSize(int w, int h) {
        super.setSize(w, h);
        hexagonalShape = getHexPolygon();
    }


    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        hexagonalShape = getHexPolygon();
    }


    @Override
    public void setBounds(Rectangle r) {
        super.setBounds(r);
        hexagonalShape = getHexPolygon();
    }


    @Override
    protected void processMouseEvent(MouseEvent e) {
        if (contains(e.getPoint()))
            super.processMouseEvent(e);
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(getBackground());
        g.drawPolygon(hexagonalShape);
        g.fillPolygon(hexagonalShape);
    }

}

