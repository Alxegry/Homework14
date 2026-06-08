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

    public void add(Searchable product) {
        for (int i = 0; i < this.archive.length; i++) {
            if (this.archive[i] == null) {
                this.archive[i] = product;
                break;
            }
        }
    }
}