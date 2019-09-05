/**
 * Developed by András Ács (acsandras@gmail.com)
 * Zealand / www.zealand.dk
 * Licensed under the MIT License
 * 2019-09-05
 */
package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import server.ChatServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChattyClient extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
        primaryStage.setTitle("Client");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();


        //@TODO Remove this shit before release
        // Dovenskab: jeg strater en server mens jeg debugger
        ChatServer cs = new ChatServer(4444);
        cs.startServer();

        //connect();
    }

    protected static void connect() {
        try {
            Socket socket = new Socket("localhost", 4444);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
