package org.example.analyzer.index;

import java.util.List;
import java.util.Map;

public class TimedInvertedIndexCollection implements Index {

    private final Index wrapped;

    public TimedInvertedIndexCollection(Index wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void addDocument(String docId, String text) {
        wrapped.addDocument(docId, text); // <--- changed name here too
    }

    @Override
    public List<Map.Entry<String, Integer>> search(String query) {
        long start = System.nanoTime();
        List<Map.Entry<String, Integer>> result = wrapped.search(query);
        long end = System.nanoTime();
        System.out.println("Search for '" + query + "' took " + (end - start) / 1_000_000.0 + " ms");
        return result;
    }
}


