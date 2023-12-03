package modelo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor implements Runnable {
    
    ServerSocket server = null;

    @Override
    public void run() {
        try {
            server = new ServerSocket(5000);
        } catch (IOException e) {
        }
        
        while (true) {            
            try {
                Socket socket = server.accept();
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF("Conectado...");
                dos.close();
                socket.close();
            } catch (Exception e) {
            }
        }
    }
    
}
