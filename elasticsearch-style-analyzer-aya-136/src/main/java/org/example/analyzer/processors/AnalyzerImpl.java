package org.example.analyzer.processors;

import org.example.analyzer.Analyzer;
import org.example.analyzer.Token;
import org.example.analyzer.enums.*;
import org.example.analyzer.processors.charFilters.CharFilterProcess;
import org.example.analyzer.processors.factories.CharFilterFactory;
import org.example.analyzer.processors.factories.TokenFilterFactory;
import org.example.analyzer.processors.factories.TokenizerFactory;
import org.example.analyzer.processors.tokenFilters.TokenFilterProcess;
import org.example.analyzer.processors.tokenizers.TokenizerProcess;

import java.util.*;


public class AnalyzerImpl implements Analyzer {
    private final List<CharFilterType> charFilters;
    private final TokenizerType tokenizer;
    private final List<TokenFilterType> tokenFilters;

    public AnalyzerImpl(List<CharFilterType> charFilters, TokenizerType tokenizer, List<TokenFilterType> tokenFilters) {
        this.charFilters = new ArrayList<>(charFilters);
        this.tokenizer = tokenizer;
        this.tokenFilters = new ArrayList<>(tokenFilters);
    }

    @Override
    public List<Token> analyze(String text) {
        if (text == null) return new ArrayList<>();

        // Apply char filters
        String processedText = text;
        for (CharFilterType filterType : charFilters) {
            CharFilterProcess filter = CharFilterFactory.getCharFilter(filterType);
            processedText = filter.applyCharFilter(processedText);  // apply method inside each filter
        }

        // Tokenize
        TokenizerProcess tokenizerInstance = TokenizerFactory.getTokenizer(tokenizer);
        List<Token> tokens = tokenizerInstance.tokenize(processedText);

        // Apply token filters
        for (TokenFilterType filterType : tokenFilters) {
            TokenFilterProcess filter = TokenFilterFactory.getTokenFilter(filterType);
            tokens = filter.applyTokenFilter(tokens);
        }

        return tokens;
    }

}