package token.operator;

public class Minus implements Binary{
    @Override
    public double apply(double a, double b) {
        return a - b;
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
