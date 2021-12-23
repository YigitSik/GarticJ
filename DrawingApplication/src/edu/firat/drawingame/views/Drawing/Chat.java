package edu.firat.drawingame.views.Drawing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Chat extends JPanel {
    public Chat() {
        setBackground(Color.decode("#7859d1"));
        setPreferredSize(new Dimension(220, 700));
        setLayout(new BorderLayout());

        Input input = new Input();
        Submit submit = new Submit();
        Area area = new Area();

        area.container.add(new Message(true, true, "Taha"));
        area.container.add(new Message(false, false, "Taha"));
        area.container.add(new Message(false, true, "Taha"));
        area.container.add(new Message(false, false, "Taha"));
        area.container.add(new Message(false, true, "Taha"));

        area.container.repaint();


        JPanel group = new JPanel();
        group.setBorder(new EmptyBorder(15, 15, 15, 15));
        group.setBackground(Color.decode("#7859d1"));

        group.setLayout(new BorderLayout());
        group.add(input, BorderLayout.CENTER);
        group.add(submit, BorderLayout.SOUTH);
        add(area, BorderLayout.CENTER);
        add(group, BorderLayout.SOUTH);


    }

    class Area extends JScrollPane {
        public JPanel container;

        public Area() {
            setBackground(Color.decode("#7859d1"));
            getViewport().setBackground(Color.decode("#7859d1"));
            setBorder(new EmptyBorder(15, 15, 15, 15));
            container = new JPanel();
            container.setBackground(Color.decode("#7859d1"));
            container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
            getViewport().add(container);


        }

    }


    class Input extends JTextField {
        public Input() {
            setBackground(Color.decode("#937ada"));
            setOpaque(true);
            setPreferredSize(new Dimension(getSize().height, 40));
            setFont(new Font("Serif", Font.BOLD, 14));
            setForeground(Color.decode("#ffffff"));
            setHorizontalAlignment(SwingConstants.CENTER);
        }
    }

    class Submit extends JButton {
        public Submit() {
            setText("Send");
            setBorder(null);
            setBackground(Color.decode("#ffffff"));
            setOpaque(true);
            setPreferredSize(new Dimension(getSize().height, 40));
            setFont(new Font("Serif", Font.BOLD, 14));
            setForeground(Color.decode("#7859d1"));
            setHorizontalAlignment(SwingConstants.CENTER);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }


    class Message extends JLabel {
        public Message(boolean status, boolean me, String nickname) {
            setOpaque(true);
            setPreferredSize(new Dimension(190, 20));
            setFont(new Font("Serif", Font.BOLD, 12));
            setBorder(new EmptyBorder(0,0,5,0));

            setBackground(Color.decode("#7859d1"));
            if (me) {
                if (status) {
                    setText(nickname + ": Doğru Cevap");
                    setForeground(Color.decode("#00FF66"));
                } else {
                    setText(nickname + ": Yanlış Cevap");
                    setForeground(Color.decode("#FF0000"));
                }
            } else {
                setForeground(Color.decode("#ffffff"));
                if (status)
                    setText("\t\t\t\t\t" + nickname + ": Doğru Cevap");
                else
                    setText("\t\t\t\t\t" + nickname + ": Yanlış Cevap");
            }


        }
    }
}
