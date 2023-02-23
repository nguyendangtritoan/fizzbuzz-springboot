package com.example.demo.model;

public class Rule {
    private final int numb;
    private final FizzBuzzEnum word;

    public FizzBuzzEnum getWord() {
        return word;
    }

    public Rule(int numb, FizzBuzzEnum word) {
        this.numb = numb;
        this.word = word;
    }

    public boolean isDivisible(int input) {
        return input % numb == 0;
    }
}
