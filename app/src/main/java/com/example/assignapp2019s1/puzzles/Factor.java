package com.example.assignapp2019s1.puzzles;

//provided in project comp2100-2019s1-code, modified by Yishun Shi
public class Factor {
    Lit _lit = null;
    Exp _exp = null;

    public Factor(Lit lit) {
        _lit = lit;
    }

    public Factor(Exp exp) {
        _exp = exp;
    }

    public String toString() {
        return _lit == null ? "(" + _exp.toString() + ")" : _lit.toString();
    }

    public int value() {
        return _lit == null ? _exp.value() : _lit.value();
    }
}
