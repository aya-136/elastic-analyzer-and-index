package org.example.analyzer.processors.tokenFilters;

import org.example.analyzer.Token;
import java.util.List;


public interface TokenFilterProcess {
    List<Token> applyTokenFilter(List<Token> tokens);
}
