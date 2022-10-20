package main.java.edu.chalmers.projecttemplate.view;

import main.java.edu.chalmers.projecttemplate.model.Hexagon;

import javax.swing.*;
import java.awt.*;

/**
 * Responsibility: Makes the tiles (jButtons) hexagonal instead of square.
 * Uses: Hexagon
 * Used by: ButtonBoard
 */

public class HexButton extends JButton {
    private Polygon hexagonalShape;
    private Hexagon hexagon;

    private Image smurfImage;

    private boolean isHovered;

    public HexButton(Hexagon hexagon) {
        this.setOpaque(false);
        hexagonalShape = getHexPolygon();
        this.hexagon = hexagon;
    }

    /**
     * Generates a hexagon button instead of default button (square).
     */
    private Polygon getHexPolygon() {
        final Polygon hex = new Polygon();
        final int width = getWidth() - 1;
        final int height = getHeight() - 1;
        final int ratio = (int) (height * .25);

        hex.addPoint(width / 2, 0);
        hex.addPoint(width, ratio);
        hex.addPoint(width, height - ratio);
        hex.addPoint(width / 2, height);
        hex.addPoint(0, height - ratio);
        hex.addPoint(0, ratio);

        return hex;
    }

    public void setSmurfImage(Image smurfImage) {
        this.smurfImage = smurfImage;
    }

    @Override
    public boolean contains(final Point point) {
        return hexagonalShape.contains(point);
    }


    @Override
    public boolean contains(final int x, final int y) {
        return hexagonalShape.contains(x, y);
    }


    @Override
    public void setSize(final Dimension dimension) {
        super.setSize(dimension);
        hexagonalShape = getHexPolygon();
    }

    @Override
    public void setSize(final int width, final int height) {
        super.setSize(width, height);
        hexagonalShape = getHexPolygon();
    }


    @Override
    public void setBounds(final int x,final int y, final int width, final int height) {
        super.setBounds(x, y, width, height);
        hexagonalShape = getHexPolygon();
    }


    @Override
    public void setBounds(Rectangle rectangle) {
        super.setBounds(rectangle);
        hexagonalShape = getHexPolygon();
    }

    @Override
    protected void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.setColor(getBackground());
        graphics.drawPolygon(hexagonalShape);
        graphics.fillPolygon(hexagonalShape);
        if (smurfImage != null){
            smurfImage = smurfImage.getScaledInstance(30,40,Image.SCALE_AREA_AVERAGING);
            graphics.drawImage(smurfImage,6,0,this);
        }
    }

    public void setNewHexagonBoard(final Hexagon hexagon){
        this.hexagon = hexagon;
    }

    /**
     *
     *
     */
    public void setHovered(boolean hovered) {
        final boolean oldValue = isHovered;
        isHovered = hovered;
        hexagon.getSupport().firePropertyChange("Hovered",oldValue,hovered);
    }

    public boolean isHexagonHovered() {
        return isHovered;
    }
}

