package org.example.analyzer.processors.charFilters;


public class NormalizationCharFilter implements CharFilterProcess {
    @Override
    public String applyCharFilter(String text) {
        return text.replaceAll("[–—]", "-");
    }
}
