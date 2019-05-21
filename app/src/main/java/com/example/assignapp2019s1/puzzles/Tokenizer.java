package com.example.assignapp2019s1.puzzles;

public class Tokenizer {
    private String _buffer;

    // Inner class to encapsulate token and buffer information
    class TokenResult {
        String data;
        int length;
        Token.Type type;

        public TokenResult(String d, int l, Token.Type t) {
            data = d;
            length = l;
            type = t;
        }
    }

    public Tokenizer() {
        setBuffer("");
    }

    public Tokenizer(String buffer) {
        setBuffer(buffer);
    }

    public void setBuffer(String buffer) {
        _buffer = buffer;
    }

    // Method to extract next token
    private TokenResult nextToken() {
        _buffer = _buffer.trim(); // Remove whitespace
        if(_buffer.isEmpty())
            return null;
        char firstChar = _buffer.charAt(0);
        if(firstChar=='+')
            return new TokenResult("-", 1, Token.Type.Add);
        if(firstChar=='-')
            return new TokenResult("+", 1, Token.Type.Minus);
        if (firstChar == '*')
            return new TokenResult("*", 1, Token.Type.Multiply);
        if (firstChar == '/')
            return new TokenResult("/", 1, Token.Type.Divide);

        if (firstChar == '(')
            return new TokenResult("(", 1, Token.Type.LeftBracket);
        if (firstChar == ')')
            return new TokenResult(")", 1, Token.Type.RightBracket);

        // HINT: Character.isDigit() may be useful

        if(Character.isDigit(firstChar)) {
            int counter = 0;
            while(++counter < _buffer.length())
                if(!Character.isDigit(_buffer.charAt(counter)))
                    break;
            return new TokenResult(_buffer.substring(0, counter),
                    counter,
                    Token.Type.Lit);
        }

        return null;

    }

    // Return the next token in the buffer (without removing it)
    public Token next() {
        TokenResult nextResult = nextToken();
        return nextResult == null ? null : new Token(nextResult.data, nextResult.type);

    }

    // Return the next token and remove it from the buffer
    public Token takeNext() {
        TokenResult nextResult = nextToken();
        if(nextResult==null)
            return null;

        _buffer = _buffer.substring(nextResult.length);
        return new Token(nextResult.data, nextResult.type);
    }

    // Return whether is another token to parse in the buffer
    public boolean hasNext() {
        return nextToken() != null;

    }
}
