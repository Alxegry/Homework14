package org.skypro.skyshop.search;

public class SearchEngine {
    public Searchable[] archive;

    public SearchEngine(int size) {
        this.archive = new Searchable[size];
    }

    public Searchable[] search(String text) {
        Searchable[] result = new Searchable[5];
        int i = 0;
        for (Searchable product : archive) {
            if (product != null && product.getSearchTerm().contains(text)) {
                result[i] = product;
                i++;
                if (i == 5) {
                    return result;
                }
            }
        }
        return result;
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
        for (int i = 0; i < this.archive.length; i++) {
            if (this.archive[i] == null) {
                this.archive[i] = product;
                break;
            }
        }
    }
}