package contacts.commands;

import contacts.Main;
import contacts.PhoneBook;

public class MenuCommand extends Command {
    public MenuCommand(PhoneBook phoneBook) {
        super(phoneBook);
    }

    @Override
    public void execute() {
        Main.setMode(ModeMenu.MENU);
    }
}
