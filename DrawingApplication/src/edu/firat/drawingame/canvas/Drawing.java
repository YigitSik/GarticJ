package edu.firat.drawingame.canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Drawing extends JFrame {


    Container container;
    DrawArea drawArea;

    public Drawing() {
        container = getContentPane();
        container.setLayout(new BorderLayout());

        drawArea = DrawArea.getInstance();
        container.add(drawArea, BorderLayout.CENTER);

        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
