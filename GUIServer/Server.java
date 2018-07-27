import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends Thread {

    private final ServerSocket serverSocket;
    private final HashMap<String, Item> stock;
   
    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(100000);      
        stock = new HashMap<>();
    }

@Override
    public void run(){
        
        while(true){
            System.out.println("Waiting for client on server "+serverSocket.getLocalPort() + "...");

            try (Socket server = serverSocket.accept()){ 
               
                System.out.println("Connected to "+server.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(server.getInputStream());
                String stockId = in.readUTF(); 
                System.out.println("Stock Id: "+stockId);
                Item item = null;
                
                if(stock.containsKey(stockId)){ 
                    item = stock.get(stockId);
                    }
               
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                System.out.println("Sending the reply to the Client...");
               
                if(item == null){
                    out.writeUTF("Item with given id does not exist");
                } else {
                    out.writeUTF(item.toString());
                }
               
            } catch(SocketTimeoutException s){
                System.out.println("Socket timed out!");
            } catch(IOException e) {}
        }
    }
  
    private void readStocks(String file) { //reads the csv file 
        try {
            BufferedReader in = new BufferedReader(new FileReader(csvFile));
           
            String record;
            while((record = in.readLine()) != null){
                String[] contents = record.split("[,\n]");
                Item item = new Item(contents[0], contents[1], Integer.valueOf(contents[2]));
                stock.put(item.getId(), item);
                in.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String [] args) { //main 
        int port = MainClient.PORT_NUMBER;
        try {
            Server t = new Server(port);
            t.readStocks("stock.csv");
            t.run();
        } catch(IOException e) {}
    }
}
    class Item{

        private final String id;
        private final String name;  
        private final int qty;

        public Item(String id, String name, int qty){
            this.id = id;
            this.name = name;
            this.qty = qty;
        }
        public String getId(){
            return id;
        }
        public String getName(){
            return name;
        }
        public int getQty(){
            return qty;
        }
        @Override
        public String toString(){
            return "Item id : " + id + ", Item Name : " + name + ", Quantity : " + qty;
        }
       
    }



