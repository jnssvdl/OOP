package expression;

public class Negation extends UnaryOperation {
    public Negation(Expression operand) {
        super(operand);
    }

    @Override
    public Integer getValue() {
        Integer value = getOperand().getValue();
        if (value != null) {
            return -value;
        }
        return null;
    }

    @Override
    public String toString() {
        Integer value = getValue();
        if (value != null) {
            return Integer.toString(value);
        }
        return String.format("-%s", getOperand().toString());
    }
}
