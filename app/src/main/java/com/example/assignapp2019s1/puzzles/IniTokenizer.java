package com.example.assignapp2019s1.puzzles;

public class IniTokenizer {
    public String _buffer;


    // inner class to encapsulate token and buffer information
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

    public IniTokenizer() {
        setBuffer("");
    }

    public IniTokenizer(String buffer) {
        setBuffer(buffer);
    }

    public void setBuffer(String buffer) {
        _buffer = buffer;
    }

    // Method to extract next token
    private TokenResult nextToken() {
        _buffer = _buffer.trim();// Remove whitespace
        if(_buffer.isEmpty())
            return null;
        char firstChar = _buffer.charAt(0);
        if(firstChar=='+')
            return new TokenResult("+", 1, Token.Type.Add);
        else if(firstChar=='-')
            return new TokenResult("-", 1, Token.Type.Minus);
        else if(firstChar=='*')
            return new TokenResult("*",1,Token.Type.Multiply);
        else if(firstChar=='/')
            return new TokenResult("/",1,Token.Type.Divide);
        else if (firstChar == '(')
            return new TokenResult("(", 1, Token.Type.LeftBracket);
        else if (firstChar == ')')
            return new TokenResult(")", 1, Token.Type.RightBracket);
        else if(Character.isDigit(firstChar))
        {
            int i;
            String tok=firstChar+"";
            for(i=1;i<_buffer.length();i++)
            {
                if(Character.isDigit(_buffer.charAt(i)))
                    tok+=Character.toString(_buffer.charAt(i));
                else break;
            }
            return new TokenResult(tok,i,Token.Type.Lit);
        }
        else
            return null;
    }



    public Token takeNext() {
        TokenResult nextResult = nextToken();
        if(nextResult==null)
            return null;
        Token t=new Token(nextResult.data,nextResult.type);
        _buffer=_buffer.substring(nextResult.length);
        return t;

    }

    public Token next() {
        TokenResult nextResult = nextToken();
        if(nextResult==null) return null;
        return new Token(nextResult.data,nextResult.type);

    }

    public boolean hasNext() {
        TokenResult nextResult = nextToken();
        if(nextResult==null) return false;
        else return true;

    }
}
