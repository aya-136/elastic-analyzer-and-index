package org.example.analyzer.index;

import org.example.analyzer.Analyzer;

import java.util.List;
import java.util.Map;

public class TimedInvertedIndexCollection extends InvertedIndexCollection {
    public TimedInvertedIndexCollection(Analyzer analyzer) {
        super(analyzer);
    }

    @Override
    public List<Map.Entry<String, Integer>> search(String query) {
        long start = System.nanoTime();
        List<Map.Entry<String, Integer>> result = super.search(query);
        long end = System.nanoTime();
        System.out.println("Search for '" + query + "' took " + (end - start) / 1_000_000.0 + " ms");
        return result;
    }
}
