package org.example.analyzer.processors.factories;

import org.example.analyzer.enums.TokenFilterType;
import org.example.analyzer.processors.tokenFilters.*;

public class TokenFilterFactory {

    public static TokenFilterProcess getTokenFilter(TokenFilterType filter) {

        return switch (filter) {
            case LOWERCASE -> new LowerCaseTokenFilter();
            case STOP_EN -> new StopWordTokenFilter();
            case ASCII_FOLD -> new AsciiFoldTokenFilter();
            case PORTER_LITE -> new PorterLiteTokenFilter();
            case EDGE_NGRAM_1_3 -> new EdgeVGramsTokenFilter();
        };
    }
}
