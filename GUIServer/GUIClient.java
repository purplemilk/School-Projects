import java.io.*;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;


public class GUIClient extends Application{

    public static void main( String[] args ){
        launch(args);
    }

@Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Stock Query Program");
        TextField input = new TextField();
        Label output = new Label("");
        Button button = new Button("Get Qty");
        
        button.setOnAction((ActionEvent t) ->{
        
        String stockId = input.getText();
        String stockData = MainClient.connect(stockId);
            output.setText(stockData);
        });
       
        GridPane layout = new GridPane();
       
        layout.add(input, 0, 0, 1, 1);
        layout.add(button, 1, 0, 1, 1);
        layout.add(output, 0, 1, 2, 1);
        layout.setHgap(10);
        layout.setVgap(10);
       
        Scene scene = new Scene(layout, 250, 100);
       
        primaryStage.setScene(scene);
        primaryStage.show();
    }   
}
    class MainClient{

    public static final String SERVER_NAME = "localhost";
    public static final int PORT_NUMBER = 10043;
   
    public static String connect(String stockId){

        System.out.println("Connecting to " + SERVER_NAME+ " on port " + PORT_NUMBER);
       
        try (Socket client = new Socket(SERVER_NAME, PORT_NUMBER)){ 
            System.out.println("Now connected to "+ client.getRemoteSocketAddress());
           
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF(stockId); 
           
            InputStream inFromServer = client.getInputStream();
            DataInputStream in =new DataInputStream(inFromServer);
            String stockInfo = in.readUTF(); 
                return stockInfo;

        } catch (IOException ex){
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
            return "Error While Contacting the Server";
        }
    }
}