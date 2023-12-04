package aseanphonebook;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Phonebook phonebook = new Phonebook();
        while (true) {
            printMenu();
            System.out.print("");
            String option = scanner.nextLine();
            if (option.equals("1")) {
                // store
                String anotherEntry = "Y";
                while (anotherEntry.equalsIgnoreCase("Y")) {
                    System.out.println();
                    store(scanner, phonebook);
                    System.out.print("Do you want to enter another entry [Y/N]? ");
                    anotherEntry = scanner.nextLine();
                }
            } else if (option.equals("2")) {
                // edit
                edit(scanner, phonebook);
            } else if (option.equals("3")) {
                // search
                search(scanner, phonebook);
            } else if (option.equals("4")) {
                // exit
                break;
            }
            System.out.println();
        }

    }

    static void printMenu() {
        System.out.println("[1] Store to ASEAN Phonebook");
        System.out.println("[2] Edit entry in ASEAN Phonebook");
        System.out.println("[3] Search ASEAN Phonebook by country");
        System.out.println("[4] Exit");
    }

    static void store(Scanner scanner, Phonebook phonebook) {
        System.out.print("Enter student number: ");
        String studentNumber = scanner.nextLine();

        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter occupation: ");
        String occupation = scanner.nextLine();

        System.out.print("Enter gender (M for male, F for female): ");
        String gender = scanner.nextLine();

        System.out.print("Enter country code: ");
        String countryCode = scanner.nextLine();

        System.out.print("Enter area code: ");
        String areaCode = scanner.nextLine();

        System.out.print("Enter number: ");
        String number = scanner.nextLine();

        Student student = new Student(studentNumber, surname, firstName, occupation, gender, countryCode, areaCode, number);
        phonebook.add(student);
    }

    static void edit(Scanner scanner, Phonebook phonebook) {
        System.out.print("\nEnter student number: ");
        String studentNumber = scanner.nextLine();
        phonebook.printInformation(studentNumber);
        Student student = phonebook.getStudent(studentNumber);
        while (true) {
            printEditChoices();
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.print("Enter new student number: ");
                String newStudentNumber = scanner.nextLine();
                student.setStudentNumber(newStudentNumber);
            } else if (choice.equals("2")) {
                System.out.print("Enter new surname: ");
                String newSurname = scanner.nextLine();
                student.setSurname(newSurname);
            } else if (choice.equals("3")) {
                System.out.print("Enter new gender: ");
                String newGender = scanner.nextLine();
                student.setGender(newGender);
            } else if (choice.equals("4")) {
                System.out.print("Enter new occupation: ");
                String newOccupation = scanner.nextLine();
                student.setOccupation(newOccupation);
            } else if (choice.equals("5")) {
                System.out.print("Enter new country code: ");
                String newCountryCode = scanner.nextLine();
                student.setCountryCode(newCountryCode);
            } else if (choice.equals("6")) {
                System.out.print("Enter new area code: ");
                String newAreaCode = scanner.nextLine();
                student.setAreaCode(newAreaCode);
            } else if (choice.equals("7")) {
                System.out.print("Enter new phone number: ");
                String newNumber = scanner.nextLine();
                student.setNumber(newNumber);
            } else if (choice.equals("8")) {
                break;
            }
        }
    }

    static void printEditChoices() {
        System.out.println("\nWhich of the following information do you wish to change?");
        System.out.println("[1] Student number     [4] Occupation        [7] Phone number");
        System.out.println("[2] Surname            [5] Country code      [8] None - Back to Main Menu");
        System.out.println("[3] Gender             [6] Area Code\n");
    }

    static void search(Scanner scanner, Phonebook phonebook) {
        printSearchChoices();
        String choice;
        int choiceCounter = 1;
        Set<String> countries = new HashSet<>();
        do {
            System.out.print("Enter choice " + choiceCounter + ": ");
            // convert choice by its corresponding country code
            choice = scanner.nextLine();
            choiceCounter++;
            if (!choice.equals("0")) {
                if (choice.equals("1")) {
                    countries.add("63");
                } else if (choice.equals("2")) {
                    countries.add("66");
                } else if (choice.equals("3")) {
                    countries.add("65");
                } else if (choice.equals("4")) {
                    countries.add("62");
                } else if (choice.equals("5")) {
                    countries.add("60");
                } else if (choice.equals("6")) {
                    countries.add("63");
                    countries.add("66");
                    countries.add("65");
                    countries.add("62");
                    countries.add("60");
                }
            }
        }
        while (!choice.equals("0"));
        String[] countriesArray = countries.toArray(new String[countries.size()]);
        Student[] students = phonebook.getStudents(countriesArray);
        phonebook.printStudentsFromCountries(countriesArray, students);
    }

    
    static void printSearchChoices() {
        System.out.println("\nFrom which country:");
        System.out.println("[1] Philippines     [4] Indonesia    [0] No more");
        System.out.println("[2] Thailand        [5] Malaysia");
        System.out.println("[3] Singapore       [6] ALL\n");
    }
    
}
