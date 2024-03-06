package contacts.commands;

import contacts.PhoneBook;

public class AddCommand extends Command {
    public AddCommand(PhoneBook phoneBook) {
        super(phoneBook);
    }

    @Override
    public void execute() {
        phoneBook.addContact();
    }
}
