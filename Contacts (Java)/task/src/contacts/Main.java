package contacts;

import contacts.commands.*;

import java.util.Scanner;

public class Main {

    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Controller controller = new Controller();
        PhoneBook phoneBook = new PhoneBook();
        Command addCommand = new AddCommand(phoneBook);
        Command removeCommand = new RemoveCommand(phoneBook);
        Command editCommand = new EditCommand(phoneBook);
        Command countCommand = new CountCommand(phoneBook);
        Command infoCommand = new InfoCommand(phoneBook);

        Commands command;
        while (true) {
            System.out.printf("Enter action (%s): ", Commands.getList());
            command = Commands.getCommandByName(sc.nextLine());
            switch (command) {
                case ADD -> controller.setCommand(addCommand);
                case REMOVE -> controller.setCommand(removeCommand);
                case EDIT -> controller.setCommand(editCommand);
                case COUNT -> controller.setCommand(countCommand);
                case INFO -> controller.setCommand(infoCommand);
                case EXIT -> {
                    return;
                }
                default -> System.out.println("Wrong command!");
            }
            controller.executeCommand();
            System.out.println();
        }
    }


}