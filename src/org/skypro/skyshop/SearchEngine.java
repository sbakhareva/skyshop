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
        int counter = 0;
        for (Searchable object : array) {
            if (object != null && object.getSearchTerm().contains(searchTerm)) {
                array[counter++] = object;
                if (counter >= array.length) {
                    break;
                }
            }
        }
        return array;
    }

    public String toString() {
        return Arrays.toString(array);
    }
}
