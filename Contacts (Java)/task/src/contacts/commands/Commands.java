package contacts.commands;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Objects;

public enum Commands {
    ADD("add", EnumSet.of(ModeMenu.MENU)),
    LIST("list", EnumSet.of(ModeMenu.MENU)),
    SEARCH("search", EnumSet.of(ModeMenu.MENU)),
    COUNT("count", EnumSet.of(ModeMenu.MENU)),
    EXIT("exit", EnumSet.of(ModeMenu.MENU)),
    EDIT("edit", EnumSet.of(ModeMenu.RECORD)),
    DELETE("delete", EnumSet.of(ModeMenu.RECORD)),
    MENU("menu", EnumSet.of(ModeMenu.RECORD)),
    NUMBER("[number]", EnumSet.of(ModeMenu.SEARCH, ModeMenu.LIST)),
    BACK("back", EnumSet.of(ModeMenu.SEARCH, ModeMenu.LIST)),
    AGAIN("again", EnumSet.of(ModeMenu.SEARCH));

    private final String name;
    private final EnumSet<ModeMenu> modeMenu;

    Commands(String name, EnumSet<ModeMenu> modeMenu) {
        this.name = name;
        this.modeMenu = modeMenu;
    }

    public static String getStringCommands(ModeMenu modeMenu) {
        StringBuilder result = new StringBuilder();
        Commands[] values = Commands.values();
        for (Commands value : values) {
            if (value.modeMenu.contains(modeMenu)) {
                result.append(value.name);
                result.append(", ");
            }
        }
        String resultString = result.toString();
        return resultString.substring(0, resultString.length() - 2);
    }

    public static Commands getCommandByName(String name) {
        return Arrays.stream(Commands.values()).filter(value -> Objects.equals(value.name, name)).findFirst().orElse(null);
    }

}
