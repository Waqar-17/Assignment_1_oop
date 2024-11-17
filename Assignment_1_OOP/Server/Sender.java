import java.io.*;
import java.net.*;

public class Sender implements Runnable {
    private Socket socket;
    private MessageManager messageManager;

    public Sender(Socket socket, MessageManager messageManager) {
        this.socket = socket;
        this.messageManager = this.messageManager;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Welcome to the server!");
            out.println("Message from server: Hello, client!");

        } catch (IOException e) {
            System.out.println("Sender error: " + e.getMessage());
        }
    }
}
