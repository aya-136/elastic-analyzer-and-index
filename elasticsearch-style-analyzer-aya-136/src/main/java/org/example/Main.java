package org.example;

import org.example.analyzer.Analyzer;
import org.example.analyzer.Token;
import org.example.analyzer.builder.AnalyzerBuilder;
import org.example.analyzer.enums.*;
import org.example.analyzer.index.InvertedIndexCollection;
import org.example.analyzer.index.TimedInvertedIndexCollection;
import org.example.analyzer.registry.AnalyzerRegistry;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Analyzer analyzer = AnalyzerBuilder.create()
                .tokenizer(TokenizerType.STANDARD)
                .addTokenFilter(TokenFilterType.LOWERCASE)
                .build();

        InvertedIndexCollection idx = new TimedInvertedIndexCollection(analyzer);
        idx.addDocument("doc1", "Hello world");
        idx.addDocument("doc2", "Hello there");
        System.out.println(idx.search("hello world"));
    }
}