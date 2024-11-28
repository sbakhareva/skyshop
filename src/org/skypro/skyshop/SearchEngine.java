package org.skypro.skyshop;

import java.util.Arrays;

public class SearchEngine {

    Searchable[] array;

    public SearchEngine(int size) {
        this.array = new Searchable[size];
    }

    public void add(Searchable object) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array [i] = object;
                break;
            }
        }
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] results = new Searchable[5];
        int counter = 0;
        for (Searchable result : results) {
            if (result != null && result.getSearchTerm().contains(searchTerm)) {
                results[counter++] = result;
                if (counter >= results.length) {
                    break;
                }
            }
        }
        return results;
    }

    public String toString() {
        return Arrays.toString(array);
    }
}
