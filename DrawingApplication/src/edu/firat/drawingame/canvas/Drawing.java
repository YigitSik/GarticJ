package edu.firat.drawingame.canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Drawing extends JFrame {


    Container container;
    DrawArea drawArea;

    JButton clearBtn, applyBtn, eraserBtn;
    JTextField colorInput, sizeInput;

    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {
                drawArea.clear();
            } else if (e.getSource() == applyBtn) {
                drawArea.setLineColor(colorInput.getText());
                float size = Float.parseFloat(sizeInput.getText());
                drawArea.setLineSize(size, 1);
            } else if (e.getSource() == eraserBtn) {
                drawArea.setLineColor("#ffffff");
            }
        }
    };

    public Drawing() {
        container = getContentPane();
        container.setLayout(new BorderLayout());

        drawArea = DrawArea.getInstance();
        container.add(drawArea, BorderLayout.CENTER);

        JPanel controls = new JPanel();

        // Clear Button
        clearBtn = new JButton("Temizle");
        clearBtn.addActionListener(actionListener);
        controls.add(clearBtn);
        // Size Button
        sizeInput = new JTextField("04");
        sizeInput.addActionListener(actionListener);
        controls.add(sizeInput);
        // Color Input
        colorInput = new JTextField("#000000");
        colorInput.addActionListener(actionListener);
        controls.add(colorInput);
        // Apply Button
        applyBtn = new JButton("Uygula");
        applyBtn.addActionListener(actionListener);
        controls.add(applyBtn);
        // Eraser Button
        eraserBtn = new JButton("Silgi");
        eraserBtn.addActionListener(actionListener);
        controls.add(eraserBtn);


        container.add(controls, BorderLayout.SOUTH);

        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
