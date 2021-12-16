package edu.firat.drawingame.canvas;

import edu.firat.drawingame.model.DrawData;
import edu.firat.drawingame.network.Network;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Arrays;
import java.util.HashMap;


public class DrawArea extends JComponent {


    private Image image;
    private Graphics2D g2D;
    private static DrawArea single_instance;
    private int currentX, currentY, oldX, oldY;

    private DrawArea() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();

                DrawData drawData = new DrawData(oldX, oldY, currentX, currentY);
                Network.sendDrawData(drawData);

                if (g2D != null) {
                    g2D.drawLine(oldX, oldY, currentX, currentY);
                    repaint();
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }

    public void drawBroadcastData(DrawData drawData) {
        if (g2D != null) {
            g2D.drawLine(drawData.oldX, drawData.oldY, drawData.currentX, drawData.currentY);
            repaint();
            drawData.oldX = currentX;
            drawData.oldY = currentY;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            g2D = (Graphics2D) image.getGraphics();
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);

    }

    public void clear() {
        setBackColor("#FFFFFF");
        g2D.fillRect(0, 0, getSize().width, getSize().height);
        setLineColor("#000000");
        setLineSize(4, 1);
        repaint();
    }

    public void setBackColor(String color) {
        g2D.setPaint(Color.decode(color));
    }

    public void setLineColor(String color) {
        g2D.setColor(Color.decode(color));
    }

    public void setLineSize(float size, float limit) {
        float dash[] = {limit};
        g2D.setStroke(new BasicStroke(size,
                BasicStroke.CAP_ROUND,// CAP_BUTT, CAP_ROUND, CAP_SQUARE
                BasicStroke.JOIN_ROUND, // JOIN_ROUND, JOIN_MITER, JOIN_BEVEL
                8.0f, dash, limit));
    }

    public static DrawArea getInstance() {
        if (single_instance == null) {
            single_instance = new DrawArea();
        }
        return single_instance;
    }

}
