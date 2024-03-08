package contacts;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PhoneBook {
    private final List<Contact> contacts = new LinkedList<>();
    private final static Scanner sc = Main.sc;

    public void editContact() {
        if (contacts.isEmpty()) {
            System.out.println("No records to edit!");
        } else {
            printContacts();
            System.out.print("Select a record: ");
            String number = sc.nextLine();
            Contact contact = contacts.get(Integer.parseInt(number) - 1);
            System.out.printf("Select a field (%s): ", contact.getListFields());
            String field = sc.nextLine();
            System.out.printf("Enter %s: ", field);
            String value = sc.nextLine();
            contact.setField(field, value);
            System.out.println("The record updated!");
        }
    }

    public void printInfo() {
        printContacts();
        System.out.print("Enter index to show info: ");
        System.out.println(contacts.get(Integer.parseInt(sc.nextLine()) - 1));
    }

    public void removeContact() {
        if (contacts.isEmpty()) {
            System.out.println("No records to remove!");
        } else {
            printContacts();
            System.out.print("Select a record: ");
            String input = sc.nextLine();
            contacts.remove(Integer.parseInt(input) - 1);
            System.out.println("The record removed!");
        }
    }

    public void addContact() {
        Contact contact = null;
        System.out.print("Enter the type (person, organization): ");
        String type = sc.nextLine();
        if (Objects.equals(type, "person")) {
            contact = new Person();
        } else if (Objects.equals(type, "organization")) {
            contact = new Organization();
        }
        String[] fields = contact != null ? contact.possibleFields() : new String[0];
        for (String field : fields) {
            System.out.printf("Enter the %s: ", field);
            contact.setField(field, sc.nextLine());
        }
        contacts.add(contact);
        System.out.println("The record added.");
    }

    public void countContacts() {
        System.out.printf("The Phone Book has %d records.\n", contacts.size());
    }

    private void printContacts() {
        for (int i = 1; i <= contacts.size(); i++) {
            System.out.printf("%d. %s\n", i, contacts.get(i - 1).getName());
        }
    }
}
