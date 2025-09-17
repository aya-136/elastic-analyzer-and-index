package org.example.analyzer.processors.charFilters;


public class MSQCharFilter implements CharFilterProcess {
    @Override
    public String applyCharFilter(String text) {
        return text
                .replace('’', '\'')
                .replace('‘', '\'')
                .replace('“', '"')
                .replace('”', '"');
    }
}
