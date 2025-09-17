package org.example.analyzer.registry;

import org.example.analyzer.Analyzer;
import org.example.analyzer.builder.AnalyzerBuilder;
import org.example.analyzer.enums.*;

import java.util.HashMap;
import java.util.Map;

public class AnalyzerRegistry {
    // TODO: simple map<String, Analyzer> with register/get
    private static final Map<String, Analyzer> registry = new HashMap<>();

    static {
        initializeDefaultAnalyzers();
    }

    private static void initializeDefaultAnalyzers() {
        // Standard analyzer: [HTML_STRIP] -> STANDARD -> [LOWERCASE, ASCII_FOLD]
        Analyzer standard = AnalyzerBuilder.create()
                .addCharFilter(CharFilterType.HTML_STRIP)
                .tokenizer(TokenizerType.STANDARD)
                .addTokenFilter(TokenFilterType.LOWERCASE)
                .addTokenFilter(TokenFilterType.ASCII_FOLD)
                .build();
        registry.put("standard", standard);

        // English analyzer: [HTML_STRIP, MAPPING_SMART_QUOTES] -> STANDARD -> [LOWERCASE, ASCII_FOLD, STOP_EN, PORTER_LITE]
        Analyzer english = AnalyzerBuilder.create()
                .addCharFilter(CharFilterType.MAPPING_SMART_QUOTES)
                .addCharFilter(CharFilterType.HTML_STRIP)
                .tokenizer(TokenizerType.STANDARD)
                .addTokenFilter(TokenFilterType.STOP_EN)
                .addTokenFilter(TokenFilterType.LOWERCASE)
                .addTokenFilter(TokenFilterType.ASCII_FOLD)
                .addTokenFilter(TokenFilterType.PORTER_LITE)
                .build();
        registry.put("english", english);
    }

    public static void register(String name, Analyzer analyzer) {
        registry.put(name, analyzer);
    }

    public static Analyzer get(String name) {
        return registry.get(name);
    }

    public static Map<String, Analyzer> defaultRegistry() {
        return new HashMap<>(registry);
    }

    public static void clear() {
        registry.clear();
        initializeDefaultAnalyzers();
    }

}
