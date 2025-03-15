import token.LBracket;
import token.RBracket;
import token.Token;
import token.VariableImp;
import token.function.FunctionFabric;
import token.number.NumberImp;
import token.operator.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Parser {
    private List<Token> tokens;

    public Parser() {
        this.tokens = new ArrayList<>();
    }

    public static void main(String[] args) {
        String expression = "2 ** 3 ** 2";

        new Parser().tokenize(expression);
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private boolean isBracket(char ch) {
        return ch == '(' || ch == ')';
    }

    private String removeSpaces(String expression) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < expression.length(); i++)
            if (expression.charAt(i) != ' ')
                builder.append(expression.charAt(i));

        return builder.toString();
    }

    public void tokenize(String expression) {
        expression = removeSpaces(expression);

        int i = 0;
        while (i < expression.length()) {
            if (isBracket(expression.charAt(i))) {
                switch (expression.charAt(i)) {
                    case '(' -> tokens.add(new LBracket());
                    case ')' -> tokens.add(new RBracket());
                }

            } else if (isOperator(expression.charAt(i))) {
                if (expression.charAt(i) == '*' && expression.charAt(i + 1) == '*') {
                    tokens.add(new PowOperator());
                    i++;

                } else if (expression.charAt(i) == '-' &&
                        (i == 0 || expression.charAt(i + 1) == '(' || isOperator(expression.charAt(i - 1)))) {
                    tokens.add(new UnaryMinus());
                } else
                    switch (expression.charAt(i)) {
                        case '+' -> tokens.add(new Plus());
                        case '-' -> tokens.add(new Minus());
                        case '*' -> tokens.add(new MultiplyOperator());
                        case '/' -> tokens.add(new DivideOperator());
                    }
            } else if (Character.isDigit(expression.charAt(i))) {
                StringBuilder number = new StringBuilder();
                while (i < expression.length() &&
                        (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    number.append(expression.charAt(i));
                    i++;
                }
                tokens.add(new NumberImp(number.toString()));
                continue;
            }
            // tokenize variable's or function's names
            else if (!Character.isDigit(expression.charAt(i))) {
                StringBuilder name = new StringBuilder().append(expression.charAt(i));
                while (i < expression.length() && !isOperator(expression.charAt(i)) && !(expression.charAt(i) == '(')) {
                    name.append(expression.charAt(i));
                    i++;
                }

                if (expression.charAt(i) == '(')
                    tokens.add(FunctionFabric.getFunctionByName(name.toString()));
                else
                    tokens.add(new VariableImp(name.toString()));
                i--;
            }

            i++;
        }

        tokens.forEach(new Consumer<Token>() {
            @Override
            public void accept(Token token) {
                System.out.println(token.getClass().getSimpleName());
            }
        });

    }
}


