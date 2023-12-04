package subjectgradetracker;

import java.util.ArrayList;

public class MajorSubject extends Subject {

    ArrayList<Integer> labScores;
    ArrayList<Integer> lecScores;

    public MajorSubject(String name, String instructor) {
        super(name, instructor);
        this.labScores = new ArrayList<Integer>();
        this.lecScores = new ArrayList<Integer>();
    }

    protected void addLabScore(int score) {
        this.labScores.add(score);
    }

    protected void addLecScore(int score) {
        this.lecScores.add(score);
    }

    protected int getLabScoresAverage() {
        return this.getAverage(this.labScores);
    }

    protected int getLecScoresAverage() {
        return this.getAverage(this.lecScores);
    }

    protected int getTotalAverage() {
        return (this.getLabScoresAverage() + this.getLecScoresAverage()) / 2;
    }

    private int getAverage(ArrayList<Integer> scores) {
        int numberOfActivities = scores.size();

        if (numberOfActivities == 0) {
            return 0;
        }

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum / numberOfActivities;
    }

    @Override
    public String toString() {
        return "Major subject: " + this.getName() + " | Instructor: " + this.getInstructor();
    }
}
