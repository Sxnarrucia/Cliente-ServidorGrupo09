package modelo;

import java.io.DataInputStream;
import java.net.Socket;


public class Cliente implements Runnable {

    @Override
    public void run() {
        final String host = "127.0.0.1";
        
        try {
            Socket socket = new Socket(host, 5000);
            
            while (true) {                
                try {
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    System.out.println(dis.readUTF());
                    dis.close();
                    socket.close();
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
        }
    }
    
}
