package main.java.edu.chalmers.projecttemplate.view;

import main.java.edu.chalmers.projecttemplate.model.Hexagon;

import javax.swing.*;
import java.awt.*;


public class HexButton extends JButton {
    private Polygon hexagonalShape;
    private Hexagon hexagon;

    private Image smurfImage;

    private boolean isHovered;

    //private Painter painter;

    public HexButton(Hexagon hexagon) {
        this.setOpaque(false);
        hexagonalShape = getHexPolygon();
        this.hexagon = hexagon;
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

    public void setSmurfImage(Image smurfImage) {
        this.smurfImage = smurfImage;
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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(getBackground());
        g.drawPolygon(hexagonalShape);
        g.fillPolygon(hexagonalShape);
        if (smurfImage != null){
            smurfImage = smurfImage.getScaledInstance(30,40,Image.SCALE_AREA_AVERAGING);
            g.drawImage(smurfImage,6,0,this);
        }
    }

    public void setNewHexagonBoard(Hexagon hexagon){
        this.hexagon = hexagon;
    }

    public void setHovered(boolean hovered) {
        boolean oldValue = isHovered;
        isHovered = hovered;
        hexagon.getSupport().firePropertyChange("Hovered",oldValue,hovered);
    }

    public boolean isHexagonHovered() {
        return isHovered;
    }
}

