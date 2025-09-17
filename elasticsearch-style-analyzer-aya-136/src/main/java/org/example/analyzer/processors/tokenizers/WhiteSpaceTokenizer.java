package org.example.analyzer.processors.tokenizers;

import org.example.analyzer.Token;
import org.example.analyzer.processors.factories.TokenizerFactory;
import org.example.analyzer.processors.tokenFilters.TokenFilterProcess;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WhiteSpaceTokenizer implements TokenizerProcess {
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");

    @Override
    public List<Token> tokenize(String text) {
        List<Token> tokens = new ArrayList<>();

        String[] parts = WHITESPACE_PATTERN.split(text.trim());
        for (String part : parts) {
            if (!part.isEmpty()) {
                tokens.add(new Token(part));
            }
        }
        return tokens;
    }
}
