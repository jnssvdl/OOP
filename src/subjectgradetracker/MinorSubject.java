package subjectgradetracker;

import java.util.ArrayList;

public class MinorSubject extends Subject{

    private ArrayList<Integer> scores;

    public MinorSubject(String name, String instructor) {
        super(name, instructor);
        this.scores = new ArrayList<Integer>();
    }

    protected void addScore(int score) {
        this.scores.add(score);
    }

    protected int getScoresAverage() {
        int numberOfActivities = this.scores.size();

        if (numberOfActivities == 0) {
            return 0;
        }

        int sum = 0;
        for (int score : this.scores) {
            sum += score;
        }
        return sum / numberOfActivities;
    }

    @Override
    public String toString() {
        return "Minor subject: " + this.getName() + " | Instructor: " + this.getInstructor();
    }
}
