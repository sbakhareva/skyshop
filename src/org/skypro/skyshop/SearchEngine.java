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
                array[i] = object;
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

    public Searchable getBestMatch(String search) throws BestResultNotFound {
        String substring = search.replace(" ", "").toLowerCase();
        int countSubstringLast = 0;
        int resultIndex = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                String text = array[i].getSearchTerm().replace(" ", "").toLowerCase();
                int counter = 0;
                int index = 0;

                while ((index = text.indexOf(substring, index)) != -1) {
                    counter++;
                    index = index + substring.length();
                }
                if (counter > countSubstringLast) {
                    countSubstringLast = counter;
                    resultIndex = i;
                }
            }
        }
        if (resultIndex == -1) {
            throw new BestResultNotFound();
        }
        return array[resultIndex];
    }

public String toString() {
    return Arrays.toString(array);
}
}
