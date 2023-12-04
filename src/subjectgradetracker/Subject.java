package subjectgradetracker;

public class Subject {

    protected String name;
    protected String instructor;

    public Subject() {}

    public Subject(String name, String instructor) {
        this.name = name;
        this.instructor = instructor;
    }

    protected String getName() {
        return this.name;
    }

    protected String getInstructor() {
        return this.instructor;
    }
}