package org.example.analyzer.processors.tokenFilters;


import org.example.analyzer.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StopWordTokenFilter implements TokenFilterProcess {

    private static final Set<String> ENGLISH_STOPWORDS = Set.of(
            "the", "and", "of", "to", "in", "a", "an", "is", "it", "for", "on"
    );

    List<Token> result = new ArrayList<>();

    @Override
    public List<Token> applyTokenFilter(List<Token> tokens) {
        tokens.stream()
                .filter(t -> !ENGLISH_STOPWORDS.contains(t.term.toLowerCase()))
                .forEach(result::add);
        return result;
    }
}