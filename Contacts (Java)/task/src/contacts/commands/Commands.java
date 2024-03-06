package contacts.commands;

import java.util.Arrays;
import java.util.Objects;

public enum Commands {
    ADD("add"),
    REMOVE("remove"),
    EDIT("edit"),
    COUNT("count"),
    INFO("info"),
    EXIT("exit");


    private final String name;

    Commands(String name) {
        this.name = name;
    }

    public static String getList() {
        StringBuilder result = new StringBuilder();
        Commands[] values = Commands.values();
        for (int i = 0; i < values.length; i++) {
            result.append(values[i].name);
            if (i < values.length - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }

    public static Commands getCommandByName(String name) {
        return Arrays.stream(Commands.values()).filter(value -> Objects.equals(value.name, name)).findFirst().orElse(null);
    }

}
