package org.example.analyzer.processors.tokenFilters;

import org.example.analyzer.Token;

import java.util.ArrayList;
import java.util.List;

public class LowerCaseTokenFilter implements TokenFilterProcess {

    @Override
    public List<Token> applyTokenFilter(List<Token> tokens) {
        List<Token> result = new ArrayList<>();
        for (Token t : tokens) {
            result.add(new Token(t.toString().toLowerCase()));
        }
        return result;
    }
}
