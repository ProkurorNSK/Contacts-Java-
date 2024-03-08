package contacts.commands;

public enum ModeMenu {
    MENU("menu"), SEARCH("search"), RECORD("record"), LIST("list");

    private final String name;

    ModeMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
