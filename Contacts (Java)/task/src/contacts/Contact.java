package contacts;

class Contact {
    private String name;
    private String surname;
    private String number;

    private Contact(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + (number.isEmpty() ? "[no number]" : number);
    }

    void setName(String name) {
        this.name = name;
    }

    void setSurname(String surname) {
        this.surname = surname;
    }

    void setNumber(String number) {
        this.number = number;
    }

    static class Builder {
        private String name;
        private String surname;
        private String number;

        Builder() {
            name = "";
            surname = "";
            number = "";
        }

        Contact build() {
            return new Contact(name, surname, number);
        }

        Builder setName(String name) {
            this.name = name;
            return this;
        }

        Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder setNumber(String number) {
            this.number = number;
            return this;
        }
    }
}
