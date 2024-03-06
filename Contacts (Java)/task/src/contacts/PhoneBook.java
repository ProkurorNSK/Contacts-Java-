package contacts;

import java.time.LocalDate;
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
            String input = sc.nextLine();
            Contact contact = contacts.get(Integer.parseInt(input) - 1);
            if (contact.isPerson()) {
                Person person = (Person) contact;
                System.out.print("Select a field (name, surname, birth, gender, number): ");
                input = sc.nextLine();
                System.out.printf("Enter %s: ", input);
                String field = sc.nextLine();
                switch (input) {
                    case "name" -> person.setName(field);
                    case "surname" -> person.setSurname(field);
                    case "birth" -> person.setBirthDate(checkData(field));
                    case "gender" -> person.setGender(checkGender(field));
                    case "number" -> person.setNumber(field);
                }
            } else {
                Organization organization = (Organization) contact;
                System.out.print("Select a field (address, number): ");
                input = sc.nextLine();
                System.out.printf("Enter %s: ", input);
                String field = sc.nextLine();
                switch (input) {
                    case "address" -> organization.setAddress(field);
                    case "number" -> organization.setNumber(field);
                }
            }
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
            System.out.print("Enter the name of the person: ");
            String name = sc.nextLine();
            System.out.print("Enter the surname of the person: ");
            String surname = sc.nextLine();
            System.out.print("Enter the birth date: ");
            String birthDate = sc.nextLine();
            LocalDate data = checkData(birthDate);
            System.out.print("Enter the gender (M, F): ");
            String gender = sc.nextLine();
            gender = checkGender(gender);
            System.out.print("Enter the number: ");
            String number = sc.nextLine();
            contact = new Person(number, name, surname, data, gender);
        } else if (Objects.equals(type, "organization")) {
            System.out.print("Enter the organization name: ");
            String name = sc.nextLine();
            System.out.print("Enter the address: ");
            String address = sc.nextLine();
            System.out.print("Enter the number: ");
            String number = sc.nextLine();
            contact = new Organization(number, name, address);
        }
        contacts.add(contact);
        System.out.println("The record added.");
    }

    private static LocalDate checkData(String birthDate) {
        LocalDate data;
        try {
            data = LocalDate.parse(birthDate);
        } catch (Exception e) {
            System.out.println("Bad birth date!");
            data = null;
        }
        return data;
    }

    private static String checkGender(String gender) {
        if (!Objects.equals(gender, "M") && !Objects.equals(gender, "F")) {
            System.out.println("Bad gender!");
            gender = "";
        }
        return gender;
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
