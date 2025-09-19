package org.example.analyzer.index;

import java.util.List;
import java.util.Map;

public interface Index {
    void addDocument(String docId, String text);
    List<Map.Entry<String, Integer>> search(String query);
}
