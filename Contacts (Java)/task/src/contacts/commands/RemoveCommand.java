package contacts.commands;

import contacts.PhoneBook;

public class RemoveCommand extends Command {
    public RemoveCommand(PhoneBook phoneBook) {
        super(phoneBook);
    }

    @Override
    public void execute() {
        phoneBook.removeContact();
    }
}
