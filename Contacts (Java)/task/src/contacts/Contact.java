package contacts;

import java.time.LocalDateTime;

class Contact {
    protected String name;
    protected String number;
    protected LocalDateTime timeCreated;
    protected LocalDateTime timeLastEdit;
    protected boolean isPerson;

    protected Contact(String number, String name) {
        this.number = checkNumber(number);
        this.name = name;
        this.timeCreated = LocalDateTime.now();
        this.timeLastEdit = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "\nNumber: " + (number.isEmpty() ? "[no number]" : number) +
                "\nTime created: " + timeCreated +
                "\nTime last edit: " + timeLastEdit;
    }

    void setNumber(String number) {
        this.number = checkNumber(number);
        timeLastEdit = LocalDateTime.now();
    }

    void setName(String name) {
        this.name = name;
        timeLastEdit = LocalDateTime.now();
    }

    String getName() {
        return name;
    }

    boolean isPerson() {
        return isPerson;
    }

    private static String checkNumber(String number) {
        String numberFormatFilter = "\\+?(\\([0-9a-zA-Z]+\\)|[0-9a-zA-Z]+([ -][(][0-9a-zA-Z]{2,}[)])?)([ -][0-9a-zA-Z]{2,})*";
        if (!number.matches(numberFormatFilter)) {
            number = "";
            System.out.println("Wrong number format!");
        }
        return number;
    }
}
