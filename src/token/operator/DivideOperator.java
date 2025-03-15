package token.operator;

public class DivideOperator implements Binary{
    @Override
    public double apply(double a, double b) {
        if (b == 0)
            throw new ArithmeticException("Zero division error: " + a + " / " + b);
        return a / b;
    }

    @Override
    public int getPriority() {
        return 2;
    }
}
