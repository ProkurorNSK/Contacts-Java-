package contacts;

import contacts.commands.*;

import java.util.Scanner;

public class Main {

    public static final Scanner sc = new Scanner(System.in);

    private static ModeMenu modeMenu = ModeMenu.MENU;

    public static void main(String[] args) {
        Controller controller = new Controller();
        PhoneBook phoneBook = new PhoneBook(args);
        Command addCommand = new AddCommand(phoneBook);
        Command deleteCommand = new DeleteCommand(phoneBook);
        Command editCommand = new EditCommand(phoneBook);
        Command countCommand = new CountCommand(phoneBook);
        Command listCommand = new ListCommand(phoneBook);
        Command menuCommand = new MenuCommand(phoneBook);
        Command numberCommand = new NumberCommand(phoneBook);
        Command searchCommand = new SearchCommand(phoneBook);

        Commands command;
        while (true) {
            System.out.printf("[%s] Enter action (%s): ", modeMenu.getName(), Commands.getStringCommands(modeMenu));
            int number = 0;
            String line = sc.nextLine();
            try {
                number = Integer.parseInt(line) - 1;
                command = Commands.NUMBER;
            } catch (Exception ignore) {
                command = Commands.getCommandByName(line);
            }
            switch (command) {
                case ADD -> controller.setCommand(addCommand);
                case DELETE -> controller.setCommand(deleteCommand);
                case EDIT -> controller.setCommand(editCommand);
                case COUNT -> controller.setCommand(countCommand);
                case LIST -> controller.setCommand(listCommand);
                case SEARCH, AGAIN -> controller.setCommand(searchCommand);
                case BACK, MENU -> controller.setCommand(menuCommand);
                case NUMBER -> {
                    phoneBook.setCurrentIndex(number);
                    controller.setCommand(numberCommand);
                }
                case EXIT -> {
                    return;
                }
                default -> System.out.println("Wrong command!");
            }
            controller.executeCommand();
            System.out.println();
        }
    }

    public static void setMode(ModeMenu modeMenu) {
        Main.modeMenu = modeMenu;
    }
}