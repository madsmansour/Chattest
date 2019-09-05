/**
 * Developed by András Ács (acsandras@gmail.com)
 * Zealand / www.zealand.dk
 * Licensed under the MIT License
 * 2019-09-05
 */
package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Controller {

    @FXML
    private TextField name;

    @FXML
    private TextField besked;

    @FXML
    private Button button;

    @FXML
    private TextArea ta;


    public void sendMessage(ActionEvent actionEvent) {
        //DEBUG
        System.out.println(name.getText());

        // Send  name til serveren
        String navn = name.getText();

        // Send besked til serveren
        String besked2 = besked.getText();

        Socket socket = null;
        try {
            socket = new Socket("localhost", 4444);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String kombineretBesked = navn + ": " + besked2 + "\n";
            dos.writeUTF(kombineretBesked);
            dos.flush();
            ta.appendText(kombineretBesked);
            //ta.appendText(dis.readUTF());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    // @TODO Readserveren fra serveren


}
