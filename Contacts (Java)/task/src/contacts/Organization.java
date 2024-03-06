package contacts;

import java.time.LocalDateTime;

public class Organization extends Contact {
    private String address;

    Organization(String number, String name, String address) {
        super(number, name);
        this.address = address;
        isPerson = false;
    }

    public void setAddress(String address) {
        this.address = address;
        timeLastEdit = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Organization name: " + name +
                "\nAddress: " + address +
                super.toString();
    }
}
