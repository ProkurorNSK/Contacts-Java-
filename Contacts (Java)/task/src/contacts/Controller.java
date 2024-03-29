package contacts;

import contacts.commands.Command;

public class Controller {

    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void executeCommand() {
        command.execute();
    }
}