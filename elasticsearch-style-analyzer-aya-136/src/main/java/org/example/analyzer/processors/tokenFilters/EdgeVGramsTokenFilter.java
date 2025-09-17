package org.example.analyzer.processors.tokenFilters;

import org.example.analyzer.Token;

import java.util.ArrayList;
import java.util.List;

public class EdgeVGramsTokenFilter implements TokenFilterProcess {

    @Override
    public List<Token> applyTokenFilter(List<Token> tokens) {
        List<Token> result = new ArrayList<>();

        tokens.forEach(t -> {
            for (int i = 1; i <= Math.min(3, t.toString().length()); i++) {
                result.add(new Token(t.toString().substring(0, i)));
            }
        });
        return result;
    }
}