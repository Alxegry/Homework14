package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> archive;
    private final Comparator<Searchable> searchableComparator = new SearchableComparator();

    public SearchEngine() {
        this.archive = new HashSet<>();
    }

    public Set<Searchable> search(String text) {
        return archive.stream()
                .filter(i -> i.getSearchTerm().contains(text))
                .collect(Collectors.toCollection(() -> new TreeSet<>(searchableComparator)));
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("Подстрока не может быть пустой строкой или null");
        }
        Searchable bestMatch = null;
        int maxCount = 0;
        for (Searchable product : archive) {
            if (product == null) continue;
            String term = product.getSearchTerm();
            int count = 0;
            int i = 0;
            int searchIndex = term.indexOf(search, i);
            while (searchIndex != -1) {
                count++;
                i = searchIndex + search.length();
                searchIndex = term.indexOf(search, i);
            }
            if (count > maxCount) {
                maxCount = count;
                bestMatch = product;
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }
        return bestMatch;
    }

    public void add(Searchable product) {
        archive.add(product);
    }
}