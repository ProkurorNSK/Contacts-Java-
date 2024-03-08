package contacts;

import java.time.LocalDateTime;

public class Organization extends Contact {
    private String address;

    Organization() {
        super();
    }

    public void setAddress(String address) {
        this.address = address;
        timeLastEdit = LocalDateTime.now().withSecond(0).withNano(0);
    }

    @Override
    String[] possibleFields() {
        return new String[]{"name", "address", "number"};
    }

    @Override
    void setField(String field, String value) {
        switch (field) {
            case "name" -> setName(value);
            case "address" -> setAddress(value);
            case "number" -> setNumber(value);
        }
    }

    @Override
    String getField(String field) {
        return switch (field) {
            case "name" -> name;
            case "address" -> address;
            case "number" -> number;
            default -> null;
        };
    }

    @Override
    public String toString() {
        return "Organization name: " + name +
                "\nAddress: " + address +
                super.toString();
    }
}
