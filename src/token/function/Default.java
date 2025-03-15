package token.function;

public class Default implements Function {
    private final String name;

    public Default(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
