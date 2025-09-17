package org.example.analyzer;

public class Token {
    public final String term;

    public Token(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return term;
    }
}
