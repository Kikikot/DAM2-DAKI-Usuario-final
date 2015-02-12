package utiles;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.AbstractBorder;

public class BordeRedondeado extends AbstractBorder {
	private Color color;
	private Color bgColor;
    private int thickness = 4;
    private int radii = 8;
    private Insets insets = null;
    private BasicStroke stroke = null;
    private int strokePad;
    private int pointerPad = 4;
    private RenderingHints hints;

    public BordeRedondeado(Color color, int thickness, int radii, Color colorEsquinas) {
        this.thickness = thickness;
        this.radii = radii;
        this.color = color;
        bgColor = colorEsquinas;

        stroke = new BasicStroke(thickness);
        strokePad = thickness / 2;

        hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int pad = radii + strokePad;
        int bottomPad = pad + strokePad;
        insets = new Insets(pad, pad, bottomPad, pad);
    }

    public Insets getBorderInsets(Component c) {
        return insets;
    }

    public Insets getBorderInsets(Component c, Insets insets) {
        return getBorderInsets(c);
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;
        int bottomLineY = height - thickness;
        RoundRectangle2D.Double bubble = new RoundRectangle2D.Double(
                0 + strokePad,
                0 + strokePad,
                width - thickness,
                bottomLineY,
                radii*5,
                radii*5);
        Polygon pointer = new Polygon();
    // left point
        pointer.addPoint(strokePad + radii + pointerPad, bottomLineY);
    // right point
        pointer.addPoint(strokePad + radii + pointerPad, bottomLineY);
    // bottom point
        pointer.addPoint(strokePad + radii + pointerPad, height - strokePad);
        Area area = new Area(bubble);
        area.add(new Area(pointer));
        g2.setRenderingHints(hints);
    // Paint the BG color of the parent, everywhere outside the clip
    // of the text bubble.
        Rectangle rect = new Rectangle(0,0,width, height);
        Area borderRegion = new Area(rect);
        borderRegion.subtract(area);
        g2.setClip(borderRegion);
        g2.setColor(bgColor);
        g2.fillRect(0, 0, width, height);
        g2.setClip(null);
        g2.setColor(color);
        g2.setStroke(stroke);
        g2.draw(area);
    }
}
