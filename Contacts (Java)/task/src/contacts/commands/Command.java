package contacts.commands;

import contacts.PhoneBook;

public abstract class Command {
    protected PhoneBook phoneBook;
    public abstract void execute();

    protected Command(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }
}
