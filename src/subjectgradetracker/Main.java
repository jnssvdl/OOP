package subjectgradetracker;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("Subject Grade Tracker");
            System.out.println("[1] Major subject");
            System.out.println("[2] Minor subject");
            System.out.println("[3] Exit program");
            System.out.print("Option: ");
            String option = scanner.nextLine();
            if (option.equals("1")) {
                majorSubject();
            } else if (option.equals("2")) {
                minorSubject();
            } else if (option.equals("3")) {
                break;
            } else {
                System.out.println("Invalid");
            }
            System.out.println();
        }
    }

    static void majorSubject() {
        System.out.print("\nEnter subject name: ");
        String subjectName = scanner.nextLine();
        System.out.print("Enter instuctor name: ");
        String instructorName = scanner.nextLine();
        MajorSubject subject = new MajorSubject(subjectName, instructorName);
        System.out.println("[1] Add lab score");
        System.out.println("[2] Display lab average");
        System.out.println("[3] Add lec score");
        System.out.println("[4] Display lec average");
        System.out.println("[5] Display total average");
        System.out.println("[6] Exit");
        System.out.println(subject);
        while (true) {
            System.out.print("Option: ");
            String option = scanner.nextLine();
            if (option.equals("1")) {
                System.out.print("Enter lab score: ");
                subject.addLabScore(scanner.nextInt());
                scanner.nextLine();
            } else if (option.equals("2")) {
                System.out.println(subject.getName() + " lab average: " + subject.getLabScoresAverage());
            } else if (option.equals("3")) {
                System.out.print("Enter lec score: ");
                subject.addLecScore(scanner.nextInt());
                scanner.nextLine();
            } else if (option.equals("4")) {
                System.out.println(subject.getName() + " lec average: " + subject.getLecScoresAverage());
            } else if (option.equals("5")) {
                System.out.println(subject.getName() + " total average: " + subject.getTotalAverage());
            } else if (option.equals("6")) {
                break;
            } else {
                System.out.println("Invalid");
            }
        }
    }

    static void minorSubject() {
        System.out.print("\nEnter subject name: ");
        String subjectName = scanner.nextLine();
        System.out.print("Enter instructor name: ");
        String instructorName = scanner.nextLine();
        MinorSubject subject = new MinorSubject(subjectName, instructorName);
        System.out.println("[1] Add score");
        System.out.println("[2] Display average");
        System.out.println("[3] Exit");
        System.out.println(subject);
        while (true) {
            System.out.print("Option: ");
            String option = scanner.nextLine();
            if (option.equals("1")) {
                System.out.print("Enter score: ");
                subject.addScore(scanner.nextInt());
                scanner.nextLine();
            } else if (option.equals("2")) {
                System.out.println(subject.getName() + " average: " + subject.getScoresAverage());
            } else if (option.equals("3")) {
                break;
            } else {
                System.out.println("Invalid");
            }
        }
    }
}
