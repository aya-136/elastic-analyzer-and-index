package org.example.analyzer.processors.factories;

import org.example.analyzer.enums.TokenizerType;
import org.example.analyzer.processors.tokenizers.StandardTokenizer;
import org.example.analyzer.processors.tokenizers.TokenizerProcess;
import org.example.analyzer.processors.tokenizers.WhiteSpaceTokenizer;


public class TokenizerFactory {

    public static TokenizerProcess getTokenizer(TokenizerType tokenizer) {

        return switch (tokenizer) {
            case WHITESPACE -> new WhiteSpaceTokenizer();
            case STANDARD -> new StandardTokenizer();
        };

    }
}
