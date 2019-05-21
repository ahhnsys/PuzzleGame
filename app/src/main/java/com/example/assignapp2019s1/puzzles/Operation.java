package com.example.assignapp2019s1.puzzles;

public enum Operation {
    None (""),
    Add ("+"),
    Sub ("-"),
    Mult ("*"),
    Div ("/");

    String op;

    Operation(String s) {
        op = s;
    }

    @Override
    public String toString() {
        return op;
    }

}
