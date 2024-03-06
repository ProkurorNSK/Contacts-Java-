package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;

class Person extends Contact {

    private String surname;
    private LocalDate birthDate;
    private String gender;

    Person(String number, String name, String surname, LocalDate birthDate, String gender) {
        super(number, name);
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        isPerson = true;
    }

    void setSurname(String surname) {
        this.surname = surname;
        timeLastEdit = LocalDateTime.now();
    }

    void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        timeLastEdit = LocalDateTime.now();
    }

    void setGender(String gender) {
        this.gender = gender;
        timeLastEdit = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nSurname: " + surname +
                "\nBirth date: " + (birthDate == null ? "[no data]" : birthDate) +
                "\nGender: " + (gender.isEmpty() ? "[no data]" : gender) +
                super.toString();
    }

    @Override
    String getName() {
        return super.getName() + " " + surname;
    }
}
