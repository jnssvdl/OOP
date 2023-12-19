package expression;

public class Variable extends Expression {
    private String name;
    private Integer value;

    
    public Variable(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
    
    public Variable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
