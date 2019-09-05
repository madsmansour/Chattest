package server;// place this file the path such ends with: ChatServer/server/ChatServer.java

import client.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer{
    Main main = new Main();

    private static final int portNumber = 4444;

    private int serverPort;
    private List<ClientThread> clients; // or "protected static List<ClientThread> clients;"
    public static void main(String[] args){

    }

    public ChatServer(int portNumber){
        this.serverPort = portNumber;
    }

    public List<ClientThread> getClients(){
        return clients;
    }

    public void startServer(){
        new Thread(() -> {
            clients = new ArrayList<ClientThread>();
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(serverPort);
                acceptClients(serverSocket);
            } catch (IOException e) {
                System.err.println("Could not listen on port: " + serverPort);
                System.exit(1);
            }
            }).start();
    }

    private void acceptClients(ServerSocket serverSocket){

        System.out.println("server starts port = " + serverSocket.getLocalSocketAddress());
        while(true){
            try{
                Socket socket = serverSocket.accept();
                System.out.println("accepts : " + socket.getRemoteSocketAddress());
                ClientThread client = new ClientThread(this, socket);
                Thread thread = new Thread(client);
                thread.start();
                clients.add(client);
            } catch (IOException ex){
                System.out.println("Accept failed on : "+serverPort);
            }
        }
    }
}
