package org.example.analyzer.processors.tokenFilters;

import org.example.analyzer.Token;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class AsciiFoldTokenFilter implements TokenFilterProcess {

    @Override
    public List<Token> applyTokenFilter(List<Token> tokens) {
        List<Token> result = new ArrayList<>();

        tokens.forEach(t -> {
            String normalized = Normalizer.normalize(t.toString(), Normalizer.Form.NFD);
            result.add(new Token(normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "")));
        });
        return result;
    }
}
