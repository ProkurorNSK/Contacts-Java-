package contacts.commands;

import contacts.Main;
import contacts.PhoneBook;

public class SearchCommand extends Command {
    public SearchCommand(PhoneBook phoneBook) {
        super(phoneBook);
    }

    @Override
    public void execute() {
        phoneBook.searchContact();
        Main.setMode(ModeMenu.SEARCH);
    }
}
