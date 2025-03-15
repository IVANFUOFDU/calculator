package token.operator;

public class Plus implements Binary{
    @Override
    public double apply(double a, double b) {
        return a + b;
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
