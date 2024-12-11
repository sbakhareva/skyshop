package org.skypro.skyshop;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;


public class SearchEngine {

    List<Searchable> array;

    public SearchEngine() {
        this.array = new ArrayList<>();
    }

    public void addItem(Searchable object) {
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) == null) {
                array.set(i, object);
                break;
            }
        }
    }

    public List<Searchable> search(String searchTerm) {
        List<Searchable> results = new ArrayList<>();
        int counter = 0;
        for (Searchable object : array) {
            if (object != null && object.getSearchTerm().contains(searchTerm)) {
                results.set(counter++, object);
                if (counter >= array.size()) {
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

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) != null) {
                String text = array.get(i).getSearchTerm().replace(" ", "").toLowerCase();
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
        return array.get(resultIndex);
    }

public String toString() {
    return array.toString();
}
}
