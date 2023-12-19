package expression;

public abstract class BinaryOperation extends Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    public BinaryOperation(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public final Expression getLeftOperand() {
        return leftOperand;
    }

    public final Expression getRightOperand() {
        return rightOperand;
    }
}
