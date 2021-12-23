package edu.firat.drawingame.views.Drawing;

import edu.firat.drawingame.model.PlayersData;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Players extends JPanel {

    PlayersData[] playersData = {new PlayersData("Rafael", 100),new PlayersData("Donatello", 88), new PlayersData("Leonardo", 61), new PlayersData("Michelangelo", 44)};
    Player[] players;


    public Players() {
        setBackground(Color.decode("#7859d1"));
        setPreferredSize(new Dimension(220, getSize().height));
        setMinimumSize(new Dimension(220, getSize().height));
        setBorder(new EmptyBorder(20,0,0,0));


        Area area = new Area();

        players = new Player[playersData.length];

        for (int i = 0; i < playersData.length; i++) {
            players[i] = new Player(i + 1, playersData[i].nickname, playersData[i].point);
            area.container.add(players[i]);
        }
        area.container.repaint();
        add(area);


    }

    class Player extends JPanel {

        JLabel orderComponent;
        JLabel pointComponent;
        JLabel nicknameComponent;

        public Player(int order, String nickname, int point) {
            setBackground(Color.decode("#7859d1"));
            setPreferredSize(new Dimension(220, 70));
            setLayout(null);

            orderComponent = new JLabel(order+"");
            orderComponent.setBounds(16, 20, 16, 16);
            orderComponent.setBackground(Color.decode("#7859d1"));
            orderComponent.setFont(new Font("Serif", Font.BOLD, 16));
            orderComponent.setOpaque(true);
            orderComponent.setForeground(Color.decode("#a18bdf"));
            add(orderComponent);


            pointComponent = new JLabel(point+"p");
            pointComponent.setBounds(40, 5, 50, 50);
            pointComponent.setBackground(Color.decode("#937ada"));
            pointComponent.setOpaque(true);
            pointComponent.setHorizontalAlignment(SwingConstants.CENTER);
            pointComponent.setVerticalAlignment(SwingConstants.CENTER);
            pointComponent.setFont(new Font("Serif", Font.BOLD, 15));
            pointComponent.setForeground(Color.decode("#e4def6"));
            add(pointComponent);

            nicknameComponent = new JLabel(nickname);
            nicknameComponent.setBounds(100, 20, 100, 20);
            nicknameComponent.setBackground(Color.decode("#7859d1"));
            nicknameComponent.setOpaque(true);
            nicknameComponent.setFont(new Font("Serif", Font.PLAIN, 14));
            nicknameComponent.setForeground(Color.decode("#ffffff"));
            add(nicknameComponent);

        }


    }


    class Area extends JScrollPane {

        public JPanel container;

        public Area() {
            setBackground(Color.decode("#7859d1"));
            setBorder(null);
            container = new JPanel();
            container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
            getViewport().add(container);


        }

    }


}
