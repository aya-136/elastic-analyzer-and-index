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

        Index index = new InvertedIndexCollection(analyzer);

        index = new TimedInvertedIndexCollection(index);

        index.addDocument("doc1", "hello world");
        index.addDocument("doc2", "hello guys");

        index.search("hello");
    }

}
