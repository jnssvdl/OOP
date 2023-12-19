package expression;

public abstract class UnaryOperation extends Expression {
    private Expression operand;

    public UnaryOperation(Expression operand) {
        this.operand = operand;
    }

    public final Expression getOperand() {
        return this.operand;
    }
}
