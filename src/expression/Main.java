package expression;

public class Main {
    public static void main(String[] args) {
        Constant c1 = new Constant(3);
        System.out.println(c1.getValue());
        System.out.println(c1.toString());

        Variable v1 = new Variable("x", 5);
        Variable v2 = new Variable("y");
        System.out.println(v1.getName());
        v1.setValue(10);
        System.out.println(v1.getValue());
        System.out.println(v2.getValue());
        System.out.println(v1.toString());
        System.out.println(v2.toString());

        Negation n1 = new Negation(c1);
        Negation n2 = new Negation(v2);
        System.out.println(n1.getOperand());
        System.out.println(n1.getValue());
        System.out.println(n1.toString());
        System.out.println(n2.getValue());

        Addition a1 = new Addition(c1, n1);
        System.out.println(a1.getLeftOperand());
        System.out.println(a1.getRightOperand());
        System.out.println(a1.getValue());
        System.out.println(a1.toString());
        Addition a2 = new Addition(v1, v2);
        System.out.println(a2.getValue());

        Multiplication m1 = new Multiplication(c1, n1);
        System.out.println(m1.getValue());
        System.out.println(m1.toString());
    }
}
