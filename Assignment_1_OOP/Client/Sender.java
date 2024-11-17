import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Sender implements Runnable {
    private Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Type your messages below (type 'exit' to quit):");
            String message;

            while (!(message = scanner.nextLine()).equalsIgnoreCase("exit")) {
                out.println(message);
            }

            socket.close();
        } catch (Exception e) {
            System.out.println("Error in Sender: " + e.getMessage());
        }
    }
}
