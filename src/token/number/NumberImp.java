package token.number;

public class NumberImp implements Number {
    private final double number;

    public NumberImp(String number) {
        this.number = Double.parseDouble(number);
    }

    @Override
    public double getValue() {
        return number;
    }
}
