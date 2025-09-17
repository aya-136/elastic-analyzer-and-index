package org.example.analyzer.processors.factories;

import org.example.analyzer.enums.CharFilterType;
import org.example.analyzer.processors.charFilters.CharFilterProcess;
import org.example.analyzer.processors.charFilters.HtmlStripCharFilter;
import org.example.analyzer.processors.charFilters.MSQCharFilter;
import org.example.analyzer.processors.charFilters.NormalizationCharFilter;

public class CharFilterFactory {
    public static CharFilterProcess getCharFilter(CharFilterType filter) {
        return switch (filter) {
            case HTML_STRIP -> new HtmlStripCharFilter();
            case MAPPING_SMART_QUOTES -> new MSQCharFilter();
            case NORMALIZE_DASHES -> new NormalizationCharFilter();
        };
    }
}