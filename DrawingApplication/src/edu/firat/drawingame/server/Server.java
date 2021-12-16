package edu.firat.drawingame.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;

    public Server(int port) {

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        startServer();
    }

    public void startServer(){

        try {
            while (!serverSocket.isClosed()){

                Socket socket = serverSocket.accept();

                System.out.println("A client has connected");
                ClientHandler clientHandler=new ClientHandler(socket);

                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void closeServerSocket(){

        try{
            if (serverSocket!=null){
                serverSocket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) throws IOException {
//
//
////        Server server = new Server();
////        server.startServer();
//
//
//    }
}