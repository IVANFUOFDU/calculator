package token.operator;

public class UnaryMinus implements Unary{
    @Override
    public double apply(double a) {
        return -a;
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
