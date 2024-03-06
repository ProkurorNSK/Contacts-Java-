package contacts.commands;

import contacts.PhoneBook;

public class EditCommand extends Command {
    public EditCommand(PhoneBook phoneBook) {
        super(phoneBook);
    }

    @Override
    public void execute() {
        phoneBook.editContact();
    }
}
