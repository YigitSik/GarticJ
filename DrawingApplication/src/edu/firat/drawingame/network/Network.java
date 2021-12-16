package edu.firat.drawingame.network;

import edu.firat.drawingame.Game;
import edu.firat.drawingame.canvas.DrawArea;
import edu.firat.drawingame.model.DrawData;

import java.io.*;
import java.net.Socket;

public class Network {

    private static Socket socket;
    private static ObjectOutputStream oos;
    private static ObjectInputStream ois;
    private static DrawArea drawArea;

    public Network(String nickname, String host, String port) {
        try {
            socket = new Socket(host, Integer.parseInt(port));
            drawArea = DrawArea.getInstance();
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            listenForDrawData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void sendDrawData(DrawData drawData) {

        try {
            oos.writeObject(drawData);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listenForDrawData() {

        new Thread(() -> {

        while (socket.isConnected()) {
            try {
                DrawData drawData = (DrawData) ois.readObject();
                drawArea.drawBroadcastData(drawData);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        }).start();

    }

}
