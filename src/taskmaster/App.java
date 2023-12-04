/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmaster;

import java.util.Scanner;

/**
 *
 * @author joeni
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of tasks: ");
        int numberOfTasks = scanner.nextInt();
        scanner.nextLine();
        
        Task[] tasks = input(scanner, numberOfTasks);
        output(numberOfTasks, tasks);
    }
    
    public static Task[] input(Scanner scanner, int numberOfTasks) {
        Task[] tasks = new Task[numberOfTasks];
        
        for (int i = 0; i < numberOfTasks; i++) {
            System.out.println("");
            
            System.out.printf("Task %d: ", i + 1);
            String name = scanner.nextLine();
            
            System.out.print("Execution: ");
            int execution = scanner.nextInt();
            
            System.out.print("Deadline: ");
            int deadline = scanner.nextInt();
            scanner.nextLine();
            
            Task task = new Task(name, execution, deadline);
            tasks[i] = task;
        }
        return tasks;
    }
    
    public static void output(int numberOfTasks, Task[] tasks) {
//        System.out.println("");
        
        int startTime = 0;
        System.out.printf("\n%-10s%-10s%-10s%-10s%-10s\n", "Tasks", "Start", "End", "Deadline", "Missed");
        for (int i = 0; i < numberOfTasks; i++) {
            tasks[i].execute(startTime);
            String missed = tasks[i].delayed() ? "Yes" : "No";
            System.out.printf("%-10s%-10d%-10d%-10d%-10s\n",tasks[i].getName(), tasks[i].getStartTime(), tasks[i].getEndTime(), tasks[i].getDeadline(), missed);
//            System.out.println(tasks[i].getName() + " " + tasks[i].getStartTime() + " " + tasks[i].getEndTime() + " " + tasks[i].getDeadline() + " " + missed);
            startTime = tasks[i].getEndTime();
        }
    }
    
}
