package org.example.analyzer.processors.charFilters;

import org.jsoup.Jsoup;
public class HtmlStripCharFilter implements CharFilterProcess {
    @Override
    public String applyCharFilter(String text) {
        return Jsoup.parse(text).text();
    }
}