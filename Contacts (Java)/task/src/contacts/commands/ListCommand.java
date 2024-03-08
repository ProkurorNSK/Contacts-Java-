package contacts.commands;

import contacts.Main;
import contacts.PhoneBook;

public class ListCommand extends Command {
    public ListCommand(PhoneBook phoneBook) {
        super(phoneBook);
    }

    @Override
    public void execute() {
        phoneBook.printList();
        Main.setMode(ModeMenu.LIST);
    }
}
