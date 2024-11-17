import java.time.LocalDateTime;

public class Message {
    private String senderId;
    private String receiverId;
    private String text;
    private LocalDateTime timestamp;
    private boolean isRead;

    public Message(String senderId, String receiverId, String text) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.text = text;
        this.timestamp = LocalDateTime.now();
        this.isRead = false;
    }
    public String getSenderId() {
        return senderId;
    }
    public String getReceiverId() {
        return receiverId;
    }
    public String getText() {
        return text;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void markAsRead() {
        this.isRead = true;
    }
    public boolean isRead() {
        return isRead;
    }
    public void displayMessageDetails() {
        System.out.println("From: " + senderId + " To: " + receiverId);
        System.out.println("Text: " + text);
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Status: " + (isRead ? "Read" : "Unread"));
    }
}
