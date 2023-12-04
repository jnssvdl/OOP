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
    
    private String name;
    private int executionTime = -1;
    private int deadline;
    private int startTime = -1;
    
    public Task(String name, int executionTime, int deadline) {
        this.name = name;
        this.executionTime = executionTime;
        this.deadline = deadline;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setExecutionTime(int time) {
        this.executionTime = time;
    }
    
    public int getExecutionTime() {
        return this.executionTime;
    }
    
    public void setDeadline(int time) {
        this.deadline = time;
    }
    
    public int getDeadline() {
        return this.deadline;
    }
    
    public void execute(int time) {
        this.startTime = time;
    }
    
    public int getStartTime() {
        return this.startTime;
    }
    
    public int getEndTime() {
        return this.startTime + this.executionTime;
    }
    
    public boolean delayed() {
        return this.getEndTime() > this.deadline;
    }
    
}
