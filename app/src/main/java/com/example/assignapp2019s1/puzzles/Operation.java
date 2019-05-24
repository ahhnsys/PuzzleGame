package com.example.assignapp2019s1.puzzles;

//provided in project comp2100-2019s1-code, modified by Yishun Shi
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
