package contacts.commands;

import contacts.PhoneBook;

public class DeleteCommand extends Command {
    public DeleteCommand(PhoneBook phoneBook) {
        super(phoneBook);
    }

    @Override
    public void execute() {
        phoneBook.deleteContact();
    }
}
