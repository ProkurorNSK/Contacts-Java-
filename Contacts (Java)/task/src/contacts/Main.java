package contacts;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<Contact> contacts = new LinkedList<>();
    private static final Scanner sc = new Scanner(System.in);

    private static final String numberFormatFilter = "\\+?(\\([0-9a-zA-Z]+\\)|[0-9a-zA-Z]+([ -][(][0-9a-zA-Z]{2,}[)])?)([ -][0-9a-zA-Z]{2,})*";

    public static void main(String[] args) {
        String command;

        while (true) {
            System.out.print("Enter action (add, remove, edit, count, list, exit): ");
            command = sc.nextLine();
            switch (command) {
                case "add" -> addContact();
                case "remove" -> removeContact();
                case "edit" -> editContact();
                case "count" -> System.out.printf("The Phone Book has %d records.\n", contacts.size());
                case "list" -> printContacts();
                case "exit" -> {
                    return;
                }
            }
        }
    }

    private static void editContact() {
        if (contacts.isEmpty()) {
            System.out.println("No records to edit!");
        } else {
            printContacts();
            System.out.print("Select a record: ");
            String input = sc.nextLine();
            Contact contact = contacts.get(Integer.parseInt(input) - 1);
            System.out.print("Select a field (name, surname, number): ");
            input = sc.nextLine();
            System.out.printf("Enter %s: ", input);
            String field = sc.nextLine();
            switch (input) {
                case "name" -> contact.setName(field);
                case "surname" -> contact.setSurname(field);
                case "number" -> {
                    if (!field.matches(numberFormatFilter)) {
                        field = "";
                        System.out.println("Wrong number format!");
                    }
                    contact.setNumber(field);
                }
            }
            System.out.println("The record updated!");
        }
    }

    private static void printContacts() {
        for (int i = 1; i <= contacts.size(); i++) {
            System.out.printf("%d. %s\n", i, contacts.get(i - 1));
        }
    }

    private static void removeContact() {
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

    private static void addContact() {
        System.out.print("Enter the name of the person: ");
        String name = sc.nextLine();
        System.out.print("Enter the surname of the person: ");
        String surname = sc.nextLine();
        System.out.print("Enter the number: ");
        String number = sc.nextLine();
        if (!number.matches(numberFormatFilter)) {
            number = "";
            System.out.println("Wrong number format!");
        }
        contacts.add(new Contact.Builder().setName(name).setSurname(surname).setNumber(number).build());
        System.out.println("The record added.");
    }
}