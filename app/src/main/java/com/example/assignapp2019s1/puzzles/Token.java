package com.example.assignapp2019s1.puzzles;

//provided in project comp2100-2019s1-code, modified by Yishun Shi
public class Token {
    public enum Type {Unknown, Lit, Add, Minus,Multiply,Divide, LeftBracket, RightBracket};
    private String _token = "";
    private Type _type = Type.Unknown;

    public Token(String token, Type type) {
        _token = token;
        _type = type;
    }

    public String token() {
        return _token;
    }

    public Type type() {
        return _type;
    }
}
