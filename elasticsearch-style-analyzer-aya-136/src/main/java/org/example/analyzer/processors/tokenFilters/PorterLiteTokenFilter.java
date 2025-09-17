package org.example.analyzer.processors.tokenFilters;

import org.example.analyzer.Token;

import java.util.List;


public class PorterLiteTokenFilter implements TokenFilterProcess {

    @Override
    public List<Token> applyTokenFilter(List<Token> tokens) {
        return tokens.stream()
                .map(t -> new Token(porterLiteStem(t.toString())))
                .toList();
    }

    private String porterLiteStem(String word) {
        String result = word;

        if (result.endsWith("ing") && result.length() > 5) {
            result = result.substring(0, result.length() - 3);
            if (result.length() >= 2) {
                char lastChar = result.charAt(result.length() - 1);
                char secondLastChar = result.charAt(result.length() - 2);
                if (lastChar == secondLastChar &&
                        "bdfglmnprt".indexOf(lastChar) != -1) {
                    result = result.substring(0, result.length() - 1);
                }
            }
        } else if (result.endsWith("ly") && result.length() > 4) {
            result = result.substring(0, result.length() - 2);
        } else if (result.endsWith("ed") && result.length() > 4) {
            result = result.substring(0, result.length() - 2);
        } else if (result.endsWith("es") && result.length() > 4) {
            result = result.substring(0, result.length() - 2);
        } else if (result.endsWith("s") && result.length() > 3 &&
                !result.endsWith("ss") && !result.endsWith("us") && !result.endsWith("is") && !result.contains("'")) {
            result = result.substring(0, result.length() - 1);
        }

        return result;
    }
}
