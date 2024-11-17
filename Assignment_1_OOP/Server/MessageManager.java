import java.util.ArrayList;

public class MessageManager {
    private ArrayList<Message> messages;

    public MessageManager() {
        messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void displayMessageHistory(String contactId) {
        System.out.println("Message History for Contact ID: " + contactId);
        for (Message message : messages) {
            if (message.getSenderId().equals(contactId) || message.getReceiverId().equals(contactId)) {
                message.displayMessageDetails();
            }
        }
    }
    public void markMessagesAsRead(String contactId) {
        for (Message message : messages) {
            if (message.getReceiverId().equals(contactId)) {
                message.markAsRead();
            }
        }
        System.out.println("Messages marked as read for Contact ID: " + contactId);
    }
    public void deleteMessagesForContact(String contactId) {
        messages.removeIf(message -> message.getSenderId().equals(contactId) || message.getReceiverId().equals(contactId));
        System.out.println("All messages deleted for Contact ID: " + contactId);
    }
    public void searchMessage(String searchTerm) {
        System.out.println("Search results for: " + searchTerm);
        for (Message message : messages) {
            if (message.getText().contains(searchTerm) || message.getSenderId().equals(searchTerm)) {
                message.displayMessageDetails();
            }
        }
    }
    public void displayAllMessages() {
        for (Message message : messages) {
            message.displayMessageDetails();
        }
    }
}
