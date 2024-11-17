import java.io.*;
import java.net.*;

public class ClientMain {
    private static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String serverIP = "127.0.0.1";
        int port = 8392;
        try (Socket socket = new Socket(serverIP, port)) {
            System.out.println("Connected to the server");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            new Thread(new Receiver(in)).start();
            String message;
            while (true) {
                System.out.print("You: ");
                message = consoleReader.readLine();
                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }
                out.println(message);
            }

            socket.close();
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
