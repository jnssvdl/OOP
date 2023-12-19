package expression;

public class Multiplication extends BinaryOperation {

    public Multiplication(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Integer getValue() {
        Integer multiplicand = getLeftOperand().getValue();
        Integer multiplier = getRightOperand().getValue();
        if (multiplicand != null && multiplier != null) {
            return multiplicand * multiplier;
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("(%s*%s)", getLeftOperand().toString(), getRightOperand().toString());
    }
}
