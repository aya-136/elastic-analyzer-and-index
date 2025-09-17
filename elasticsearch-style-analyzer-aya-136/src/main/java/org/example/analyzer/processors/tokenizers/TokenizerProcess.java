package org.example.analyzer.processors.tokenizers;

import org.example.analyzer.Token;
import org.example.analyzer.enums.TokenizerType;

import java.util.List;

public interface TokenizerProcess {
    List<Token> tokenize(String text);
}
