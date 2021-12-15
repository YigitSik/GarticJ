package edu.firat.drawingame.model;

import java.io.Serializable;

public class DrawData implements Serializable {

    public int oldX,oldY,currentX,currentY;

    public DrawData(int oldX, int oldY, int currentX, int currentY) {
        this.oldX = oldX;
        this.oldY = oldY;
        this.currentX = currentX;
        this.currentY = currentY;
    }
}
