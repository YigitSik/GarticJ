package edu.firat.drawingame.server;

import edu.firat.drawingame.model.DrawData;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public ClientHandler(Socket socket){
        try {
            this.socket = socket;
            this.oos = new ObjectOutputStream(socket.getOutputStream());
            this.ois = new ObjectInputStream(socket.getInputStream());
            clientHandlers.add(this);
            System.out.println("SERVER: someone has entered the chat!");
        } catch (IOException e) {
            closeEverything(socket,oos,ois);
        }
    }

    @Override
    public void run() {

        while (socket.isConnected()){
            try {
                DrawData drawData = (DrawData) ois.readObject();
                broadcastDrawData(drawData);
            } catch (IOException | ClassNotFoundException e){
                closeEverything(socket,oos,ois);
                break;
            }
        }
    }

    public void broadcastDrawData(DrawData drawData){

        for (ClientHandler clientHandler : clientHandlers){
            try {
                clientHandler.oos.writeObject(drawData);
                clientHandler.oos.flush();
            } catch (IOException e){
                closeEverything(socket,oos,ois);
            }
        }

    }

    public void removeClientHandler(){
        clientHandlers.remove(this);
        System.out.println(("SERVER: someone has left the chat!"));
    }

    public void closeEverything(Socket socket, ObjectOutputStream oos, ObjectInputStream ois){
        removeClientHandler();
        try {
            if (ois!=null){
                ois.close();
            }
            if (oos !=null){
                oos.close();
            }
            if (socket !=null){
                socket.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
