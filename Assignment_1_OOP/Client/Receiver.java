import java.io.*;

public class Receiver implements Runnable {
    private BufferedReader in;

    public Receiver(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Server: " + message);
            }
        } catch (IOException e) {
            System.out.println("Receiver error: " + e.getMessage());
        }
    }
}
