import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server{
    private static ArrayList<Contact> contacts = Contact.initializeContacts();
    private static MessageManager messageManager = new MessageManager();

    public static void main(String[] args) {
        int port = 8392;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");


                new Thread(() -> handleClient(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    private static void handleClient(Socket socket) {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String command;
            out.println("Welcome to the server! Type 'help' for available commands.");

            while ((command = in.readLine()) != null) {
                switch (command.toLowerCase()) {
                    case "help":
                        out.println("Commands: \n 1- view_contacts \n 2-send_message \n 3-view_messages \n 4- mark_read \n 5- delete_messages \n 6-exit");
                        break;

                    case "view_contacts":
                        for (Contact contact : contacts) {
                            out.println(contact.getContactId() + ": " + contact.getName());
                        }
                        break;

                    case "send_message" :
                        out.println("Enter Receiver ID:");
                        String receiverId = in.readLine();
                        out.println("Enter Message Text:");
                        String text = in.readLine();
                        Message message = new Message("server", receiverId, text);
                        messageManager.addMessage(message);
                        out.println("Message sent to Contact ID: " + receiverId);
                        break;

                    case "view_messages" :
                        out.println("Enter Contact ID to view messages:");
                        String contactId = in.readLine();
                        messageManager.displayMessageHistory(contactId);
                        break;

                    case "mark_read":
                        out.println("Enter Contact ID to mark messages as read:");
                        contactId = in.readLine();
                        messageManager.markMessagesAsRead(contactId);
                        out.println("Messages marked as read for Contact ID: " + contactId);
                        break;

                    case "delete_messages" :
                        out.println("Enter Contact ID to delete messages:");
                        contactId = in.readLine();
                        messageManager.deleteMessagesForContact(contactId);
                        out.println("Messages deleted for Contact ID: " + contactId);
                        break;
				
					case "exit" :
                        out.println("Goodbye!");
                        return;

                    default:
                        out.println("Unknown command. Type 'help' for a list of commands.");
                }
            }
        } catch (IOException e) {
            System.out.println("Client disconnected: " + e.getMessage());
        }
    }
}
