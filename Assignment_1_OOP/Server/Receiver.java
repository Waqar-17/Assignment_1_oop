import java.io.*;
import java.net.*;

public class Receiver implements Runnable {
    private Socket socket;
    private MessageManager messageManager;

    public Receiver(Socket socket, MessageManager messageManager) {
        this.socket = socket;
        this.messageManager = messageManager;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message;

            while ((message = in.readLine()) != null) {
                System.out.println("Received message from client: " + message);
            }
        } catch (IOException e) {
            System.out.println("Receiver error: " + e.getMessage());
        }
    }
}
