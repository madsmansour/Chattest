package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import java.awt.*;


public class Controller {

    public void startServer(ActionEvent actionEvent) {
        ChatServer chatServer = new ChatServer(4444);
        chatServer.startServer();
        System.out.println("Hej");
    }
}
