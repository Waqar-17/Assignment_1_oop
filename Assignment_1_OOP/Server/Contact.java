import java.util.ArrayList;

public class Contact {
    private String contactId;
    private String name;

    public Contact(String contactId, String name) {
        this.contactId = contactId;
        this.name = name;
    }

    public String getContactId() {
        return contactId;
    }

    public String getName() {
        return name;
    }

    public void displayContactDetails() {
        System.out.println("ID: " + contactId + ", Name: " + name);
    }

    // Static method to initialize contacts
    public static ArrayList<Contact> initializeContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("1", "Alice"));
        contacts.add(new Contact("2", "Bob"));
        contacts.add(new Contact("3", "Charlie"));
        return contacts;
    }
}
