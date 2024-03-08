package contacts;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneBook {
    private List<Contact> contacts;

    private int currentIndex;
    private final File file;
    private final static Scanner sc = Main.sc;

    public PhoneBook(String[] path) {
        String dir = ".\\Contacts (Java)\\task\\src\\contacts\\";
        if (path.length == 0 || !new File(dir + path[0]).exists() || new File(dir + path[0]).isDirectory()) {
            this.file = new File(dir + "phonebook.db");
            try {
                //noinspection ResultOfMethodCallIgnored
                this.file.createNewFile();
            } catch (IOException ignored) {
            }
            contacts = new LinkedList<>();
            savePhoneBook();
        } else {
            this.file = new File(dir + path[0]);
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.file))) {
                //noinspection unchecked
                contacts = (List<Contact>) ois.readObject();
                System.out.println("open " + path[0]);
                System.out.println();
            } catch (Exception ignored) {
                contacts = new LinkedList<>();
                savePhoneBook();
            }
        }
    }

    private void savePhoneBook() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.file))) {
            oos.writeObject(contacts);
        } catch (Exception ignored) {
        }
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
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
        savePhoneBook();
    }

    public void printContact() {
        System.out.println(contacts.get(currentIndex));
    }

    public void editContact() {
        Contact contact = contacts.get(currentIndex);
        System.out.printf("Select a field (%s): ", contact.getListFields());
        String field = sc.nextLine();
        System.out.printf("Enter %s: ", field);
        String value = sc.nextLine();
        contact.setField(field, value);
        System.out.println("Saved");
        savePhoneBook();
        printContact();
    }

    public void deleteContact() {
        contacts.remove(currentIndex);
        System.out.println("The record removed!");
        savePhoneBook();
    }

    public void countContacts() {
        System.out.printf("The Phone Book has %d records.\n", contacts.size());
    }

    public void printList() {
        for (int i = 1; i <= contacts.size(); i++) {
            System.out.printf("%d. %s\n", i, contacts.get(i - 1).getName());
        }
    }

    public void searchContact() {
        System.out.print("Enter search query: ");
        String query = sc.nextLine();

        List<Contact> resultSearch = new LinkedList<>();
        for (Contact contact : contacts) {
            String[] fields = contact != null ? contact.possibleFields() : new String[0];
            for (String field : fields) {
                if (contact.getField(field).matches(query)) {
                    resultSearch.add(contact);
                    break;
                }
            }
        }

        System.out.printf("Found %d results:\n", resultSearch.size());
        for (int i = 1; i <= resultSearch.size(); i++) {
            System.out.printf("%d. %s\n", i, contacts.get(i - 1).getName());
        }
    }
}
