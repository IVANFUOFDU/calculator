package token.operator;

import token.Token;

public interface Operator extends Token {
    public int getPriority();
}
