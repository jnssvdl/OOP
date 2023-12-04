package aseanphonebook;

public class Student {
    String studentNumber;
    String surname;
    String firstName;
    String occupation;
    String gender;
    String countryCode;
    String areaCode;
    String number;

    Student(String studentNumber, String surname, String firstName, String occupation, String gender, String countryCode, String areaCode, String number) {
        this.studentNumber = studentNumber;
        this.surname = surname;
        this.firstName = firstName;
        this.occupation = occupation;
        this.gender = gender;
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.number = number;
    }

    String getStudentNumber() {
        return this.studentNumber;
    }

    void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    String getSurname() {
        return this.surname;
    }

    void setSurname(String surname) {
        this.surname = surname;
    }

    String getFirstName() {
        return this.firstName;
    }

    // wag gamitin
    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getOccupation() {
        return this.occupation;
    }

    void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    String getGender() {
        return this.gender;
    }

    void setGender(String gender) {
        this.gender = gender;
    }

    String getCountryCode() {
        return this.countryCode;
    }

    void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    String getAreaCode() {
        return this.areaCode;
    }

    void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    String getNumber() {
        return this.number;
    }

    void setNumber(String number) {
        this.number = number;
    }

    public String toString() {
        String pronoun = this.gender.equals("M") ? "His" : this.gender.equals("F") ? "Her" : "Their";
        String format = String.format("%s, %s, with student number %s, is a %s. %s phone number is %s-%s-%s", this.surname, this.firstName, this.studentNumber, this.occupation.toLowerCase(), pronoun, this.countryCode, this.areaCode, this.number);
        return format;
    }
}
