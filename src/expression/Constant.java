package expression;

public class Constant extends Expression {
    private Integer value;

    public Constant(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
    
}
