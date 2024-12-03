package org.skypro.skyshop;

import org.skypro.skyshop.exceptions.BestResultNotFound;

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
        for (Searchable object : array) {
            if (object != null && object.getSearchTerm().contains(searchTerm)) {
                results[counter++] = object;
                if (counter >= array.length) {
                    break;
                }
            }
        }
        return results;
    }

    public Searchable[] getBestMatch(String search) {
        Searchable[] objects = new Searchable[5];
        int counter = 0;

        for (Searchable object : array) {
            if (object != null && counter < array.length) {
                String string = object.getSearchTerm();

                String substring = search;
                int index = 0;
                int substringIndex = string.indexOf(substring, index);

                while (substringIndex != -1 && counter < array.length) {
                    objects[counter++] = object;
                    index = index + substring.length();
                    substringIndex = string.indexOf(substring, index);
                }
            }
        }
        if (objects[0] == null) {
            try {
                throw new BestResultNotFound();
            } catch (BestResultNotFound e) {
                System.out.println("По запросу \"" + search + "\" ничего не найдено.");
            }
        }
        return objects;
    }

    public String toString() {
        return Arrays.toString(array);
    }
}
