package expression;

public class Addition extends BinaryOperation {

    public Addition(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
        //TODO Auto-generated constructor stub
    }

    @Override
    public Integer getValue() {
        Integer augend = getLeftOperand().getValue();
        Integer addend = getRightOperand().getValue();
        if (augend != null && addend != null) {
            return augend + addend;
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("(%s+%s)", getLeftOperand().toString(), getRightOperand().toString());
    }
    
}
