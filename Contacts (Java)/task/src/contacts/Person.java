package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

class Person extends Contact {

    private String surname;
    private LocalDate birthDate;
    private String gender;

    Person() {
        super();
    }

    @Override
    String[] possibleFields() {
        return new String[]{"name", "surname", "birth", "gender", "number"};
    }

    @Override
    void setField(String field, String value) {
        switch (field) {
            case "name" -> setName(value);
            case "surname" -> setSurname(value);
            case "birth" -> setBirthDate(value);
            case "gender" -> setGender(value);
            case "number" -> setNumber(value);
        }
    }

    @Override
    String getField(String field) {
        return switch (field) {
            case "name" -> name;
            case "surname" -> surname;
            case "birth" -> birthDate.toString();
            case "gender" -> gender;
            case "number" -> number;
            default -> null;
        };
    }

    void setSurname(String surname) {
        this.surname = surname;
        timeLastEdit = LocalDateTime.now().withSecond(0).withNano(0);
    }

    void setBirthDate(String birthDate) {
        this.birthDate = checkData(birthDate);
        timeLastEdit = LocalDateTime.now().withSecond(0).withNano(0);
    }

    void setGender(String gender) {
        this.gender = checkGender(gender);
        timeLastEdit = LocalDateTime.now().withSecond(0).withNano(0);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nSurname: " + surname + "\nBirth date: " + (birthDate == null ? "[no data]" : birthDate) + "\nGender: " + (gender.isEmpty() ? "[no data]" : gender) + super.toString();
    }

    @Override
    String getName() {
        return super.getName() + " " + surname;
    }

    private static LocalDate checkData(String birthDate) {
        LocalDate data;
        try {
            data = LocalDate.parse(birthDate);
        } catch (Exception e) {
            System.out.println("Bad birth date!");
            data = null;
        }
        return data;
    }

    private static String checkGender(String gender) {
        if (!Objects.equals(gender, "M") && !Objects.equals(gender, "F")) {
            System.out.println("Bad gender!");
            gender = "";
        }
        return gender;
    }
}
