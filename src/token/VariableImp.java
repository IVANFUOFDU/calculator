package token;

public class VariableImp implements Variable {
    private final String name;

    public VariableImp(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
