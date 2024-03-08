package contacts.commands;

import contacts.Main;
import contacts.PhoneBook;

public class NumberCommand extends Command {

    public NumberCommand(PhoneBook phoneBook) {
        super(phoneBook);
    }

    @Override
    public void execute() {
        phoneBook.printContact();
        Main.setMode(ModeMenu.RECORD);
    }
}
