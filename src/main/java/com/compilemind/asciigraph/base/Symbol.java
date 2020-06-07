package com.compilemind.asciigraph.base;

public enum Symbol {
    NONE(' '),
    BLANK(' '),
    EQUAL('='),
    ASTERISK('*'),
    PLUS('+'),
    DOT('.');

    public char getSymbol() {
        return symbol;
    }

    private final char symbol;

    Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
