import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {

    private ArrayList<Contact> contacts;
    private Scanner scanner;

    public ContactManager() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact() {
        System.out.println("Enter contact name:");
        String name = scanner.nextLine();
        System.out.println("Enter contact phone number:");
        String phoneNumber = scanner.nextLine();
        contacts.add(new Contact(name, phoneNumber));
        System.out.println("Contact added successfully!");
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("Contacts list:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void deleteContact() {
        System.out.println("Enter the name of the contact to delete:");
        String name = scanner.nextLine();
        boolean found = false;
        
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                found = true;
                System.out.println("Contact deleted successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Contact with name '" + name + "' not found.");
        }
    }

    public void searchContact() {
        System.out.println("Enter the name to search:");
        String name = scanner.nextLine();
        boolean found = false;
        
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Found contact: " + contact);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Display menu
    public void displayMenu() {
        System.out.println("\nContact Management System");
        System.out.println("1. Add Contact");
        System.out.println("2. View Contacts");
        System.out.println("3. Delete Contact");
        System.out.println("4. Search Contact");
        System.out.println("5. Exit");
    }

    public void start() {
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    searchContact();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);
    }

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        contactManager.start();
    }
}
