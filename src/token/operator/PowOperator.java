package token.operator;

public class PowOperator implements Binary{
    @Override
    public double apply(double a, double b) {
        return Math.pow(a, b);
    }

    @Override
    public int getPriority() {
        return 3;
    }
}
