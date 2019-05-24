package com.example.assignapp2019s1.puzzles;

//provided in project comp2100-2019s1-code, modified by Yishun Shi
public class Lit {
    private int _value = 0;

    public Lit(int value) {
        _value = value;
    }

    public int value() {
        return _value;
    }

    public String toString() {
        return Integer.toString(_value);
    }
}
