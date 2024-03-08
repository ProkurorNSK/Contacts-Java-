package contacts;

import java.io.Serializable;
import java.time.LocalDateTime;

abstract class Contact implements Serializable {
    protected String name;
    protected String number;
    protected LocalDateTime timeCreated;
    protected LocalDateTime timeLastEdit;

    protected Contact() {
        this.timeCreated = LocalDateTime.now().withSecond(0).withNano(0);
        this.timeLastEdit = LocalDateTime.now().withSecond(0).withNano(0);
    }

    abstract String[] possibleFields();

    abstract void setField(String field, String value);

    abstract String getField(String field);

    @Override
    public String toString() {
        return "\nNumber: " + (number.isEmpty() ? "[no number]" : number) + "\nTime created: " + timeCreated + "\nTime last edit: " + timeLastEdit;
    }

    void setNumber(String number) {
        this.number = checkNumber(number);
        timeLastEdit = LocalDateTime.now().withSecond(0).withNano(0);
    }

    void setName(String name) {
        this.name = name;
        timeLastEdit = LocalDateTime.now().withSecond(0).withNano(0);
    }

    String getName() {
        return name;
    }

    private static String checkNumber(String number) {
        String numberFormatFilter = "\\+?(\\([0-9a-zA-Z]+\\)|[0-9a-zA-Z]+([ -][(][0-9a-zA-Z]{2,}[)])?)([ -][0-9a-zA-Z]{2,})*";
        if (!number.matches(numberFormatFilter)) {
            number = "";
            System.out.println("Wrong number format!");
        }
        return number;
    }

    public String getListFields() {
        StringBuilder result = new StringBuilder();
        String[] fields = possibleFields();
        for (int i = 0; i < fields.length; i++) {
            result.append(fields[i]);
            if (i < fields.length - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }
}
