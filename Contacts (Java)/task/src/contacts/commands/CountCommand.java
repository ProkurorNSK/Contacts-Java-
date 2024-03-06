package contacts.commands;

import contacts.PhoneBook;

public class CountCommand extends Command {
    public CountCommand(PhoneBook phoneBook) {
        super(phoneBook);
    }

    @Override
    public void execute() {
        phoneBook.countContacts();
    }
}
