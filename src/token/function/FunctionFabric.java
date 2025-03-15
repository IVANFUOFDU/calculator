package token.function;

public class FunctionFabric {
    public static Function getFunctionByName(String name) {
        return new Default(name);
    }
}
