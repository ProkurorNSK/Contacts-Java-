package contacts.commands;

import contacts.PhoneBook;

public class InfoCommand extends Command {
    public InfoCommand(PhoneBook phoneBook) {
        super(phoneBook);
    }

    @Override
    public void execute() {
        phoneBook.printInfo();
    }
}
