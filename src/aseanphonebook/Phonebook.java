package aseanphonebook;

import java.util.ArrayList;

public class Phonebook {
    static Student[] phonebook = new Student[0];
    
    void add(Student student) {
        int n = phonebook.length;
        Student[] temp = new Student[n + 1];
        for (int i = 0; i < n; i++) {
            temp[i] = phonebook[i];
        }
        temp[n] = student;
        phonebook = temp;
    }

    Student getStudent(String studentNumber) {
        for (int i = 0; i < phonebook.length; i++) {
            Student student = phonebook[i];
            if (studentNumber.equals(student.getStudentNumber())) {
                return student;
            }
        }
        throw new RuntimeException();
    }

    void printInformation(String studentNumber) {
        Student student = getStudent(studentNumber);
        String pronoun = student.getGender().equals("M") ? "His" : student.getGender().equals("F") ? "Her" : "Their";
        String information = student.getFirstName() + " " + student.getSurname() + " is a " + student.getOccupation() + ". " + pronoun + " number is " + student.getCountryCode() + "-" + student.getAreaCode() + "-" + student.getNumber();
        System.out.println("Here is the existing information about " + studentNumber + ":");
        System.out.println(information);
    }

    Student[] getStudents(String[] countries) {
        ArrayList<Student> students = new ArrayList<Student>();
        for (int i = 0; i < phonebook.length; i++) {
            Student student = phonebook[i];
            for (int j = 0; j < countries.length; j++) {
                String country = countries[j];
                if (student.getCountryCode().equals(country)) {
                    students.add(student);
                }
            }
        }
        Student[] studentsArray = students.toArray(new Student[students.size()]);
        return sort(studentsArray);
    }

    Student[] sort(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (students[i].getSurname().compareTo(students[j].getSurname()) > 0) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        return students;
    }

    void printStudentsFromCountries(String[] countriesArray, Student[] students) {
        String from = "\nHere are the students from ";
        int n = countriesArray.length;
        for (int i = 0; i < n; i++) {
            String countryCode = countriesArray[i];
            String country = "";
            if (countryCode.equals("60")) {
                country = "Malaysia";
            } else if (countryCode.equals("62")) {
                country = "Indonesia";
            } else if (countryCode.equals("63")) {
                country = "Philippines";
            } else if (countryCode.equals("65")) {
                country = "Singapore";
            } else if (countryCode.equals("66")) {
                country = "Thailand";
            }
            from += (n == 1 ? country : (i == n - 1 ? " and " + country : (i == n - 2 ? country : country + ", ")));
        }
        System.out.println(from + ":");
        for (Student student : students) {
            System.out.println("\n" + student.toString());
        }
    }

}
