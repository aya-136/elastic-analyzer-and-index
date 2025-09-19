package org.example.analyzer.index;

import org.example.analyzer.Analyzer;
import org.example.analyzer.Token;
import java.util.*;

public class InvertedIndexCollection implements Index{
    private final Analyzer analyzer;

    // term -> set of docIds containing that term
    private final Map<String, Set<String>> index;

    // docId -> original document text
    private final Map<String, String> documents;

    public InvertedIndexCollection(Analyzer analyzer) {
        this.analyzer = analyzer;
        this.index = new HashMap<>();
        this.documents = new HashMap<>();
    }

    /**
     * Add a document to the index.
     */
    public void addDocument(String docId, String text) {
        // TODO
        documents.put(docId, text);
        List<Token> tokens = analyzer.analyze(text);

        for (Token token : tokens) {
            String term = token.term;
            index.computeIfAbsent(term, k -> new HashSet<>()).add(docId);
        }
    }

    /**
     * Search the index with a query string.
     * Score = number of distinct query tokens found in each document.
     * Sort by score desc, then docId asc.
     */
    public List<Map.Entry<String, Integer>> search(String query) {
        if (query == null || query.isEmpty()) {
            return Collections.emptyList();
        }

        List<Token> queryTokens = analyzer.analyze(query);
        if (queryTokens.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, Integer> documentScores = new HashMap<>(); // (docId -> score)

        for (Token token : queryTokens) {
            String term = token.term;
            Set<String> docsWithTerm = index.get(term);

            if (docsWithTerm != null) {
                for (String docId : docsWithTerm) {
                    documentScores.put(docId, documentScores.getOrDefault(docId, 0) + 1);
                }
            }
        }
//        List<String> results = new ArrayList<>(documentScores.keySet());
//        results.sort((doc1, doc2) -> {
//            int score1 = documentScores.get(doc1);
//            int score2 = documentScores.get(doc2);
//
//            if (score1 != score2) {
//                return Integer.compare(score2, score1);
//            }
//            return doc1.compareTo(doc2);
//        });
//        return results;
//    }
        List<Map.Entry<String, Integer>> results = new ArrayList<>(documentScores.entrySet());
        results.sort((e1, e2) -> {
            int scoreCompare = Integer.compare(e2.getValue(), e1.getValue());
            return (scoreCompare != 0) ? scoreCompare : e1.getKey().compareTo(e2.getKey());
        });

        return results;
    }
}

