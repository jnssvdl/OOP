/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmaster;

/**
 *
 * @author joeni
 */
public class Task {
    
    String name;
    int executionTime;
    int deadline;
    int startTime = -1;
    
    Task() {}
    
    Task(String name, int executionTime, int deadline) {
        this.name = name;
        this.executionTime = executionTime;
        this.deadline = deadline;
    }
    
    void setName(String name) {
        this.name = name;
    }
    
    String getName() {
        return this.name;
    }
    
    void setExecutionTime(int time) {
        this.executionTime = time;
    }
    
    int getExecutionTime() {
        return this.executionTime;
    }
    
    void setDeadline(int time) {
        this.deadline = time;
    }
    
    int getDeadline() {
        return this.deadline;
    }
    
    void execute(int time) {
        this.startTime = time;
    }
    
    int getStartTime() {
        return this.startTime;
    }
    
    int getEndTime() {
        return this.startTime > -1 ? this.startTime + this.executionTime : -1;
    }
    
    boolean delayed() {
        return this.getEndTime() > this.deadline;
    }
    
}
