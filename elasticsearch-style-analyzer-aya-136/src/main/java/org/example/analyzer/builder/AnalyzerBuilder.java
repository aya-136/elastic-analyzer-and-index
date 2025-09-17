package org.example.analyzer.builder;

import org.example.analyzer.Analyzer;
import org.example.analyzer.enums.CharFilterType;
import org.example.analyzer.enums.TokenFilterType;
import org.example.analyzer.enums.TokenizerType;
import org.example.analyzer.processors.AnalyzerImpl;

import java.util.ArrayList;
import java.util.List;

public class AnalyzerBuilder {
    private final List<CharFilterType> charFilters;
    private TokenizerType tokenizer;
    private final List<TokenFilterType> tokenFilters;

    private AnalyzerBuilder() {
        this.charFilters = new ArrayList<>();
        this.tokenFilters = new ArrayList<>();
    }

    // TODO: keep internal ordered lists of charFilters and tokenFilters, and a tokenizer
    public static AnalyzerBuilder create() {
        return new AnalyzerBuilder();
    }

    public AnalyzerBuilder addCharFilter(CharFilterType charFilter) {
        this.charFilters.add(charFilter);
        return this;
    }

    public AnalyzerBuilder tokenizer(TokenizerType tokenizer) {
        this.tokenizer = tokenizer;
        return this;
    }

    public AnalyzerBuilder addTokenFilter(TokenFilterType tokenFilter) {
        this.tokenFilters.add(tokenFilter);
        return this;
    }

    /**
     * Build an Analyzer that executes: charFilters -> tokenizer -> tokenFilters
     */
    public Analyzer build() {
        if (tokenizer == null) {
            throw new IllegalStateException("Tokenizer must be specified");
        }
        return new AnalyzerImpl(charFilters, tokenizer, tokenFilters);
    }

}

