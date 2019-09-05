package server;

import javafx.event.ActionEvent;


public class Controller {

    public void startServer(ActionEvent actionEvent) {
        System.out.println("Serveren startes...");
        ChatServer chatServer = new ChatServer(4444);
        chatServer.startServer();
    }
}
