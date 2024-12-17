package org.skypro.skyshop;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;


public class SearchEngine {

    List<Searchable> searchList;

    public SearchEngine() {
        this.searchList = new ArrayList<>();
    }

    public void addItem(Searchable object) {
        searchList.add(object);
    }

    public List<Searchable> search(String searchTerm) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable object : searchList) {
            if (object.getSearchTerm().contains(searchTerm)) {
                results.add(object);
            }
        }
        return results;
    }

    public Searchable getBestMatch(String search) throws BestResultNotFound {
        String substring = search.replace(" ", "").toLowerCase();
        int countSubstringLast = 0;
        int resultIndex = -1;

        for (int i = 0; i < searchList.size(); i++) {
                String text = searchList.get(i).getSearchTerm().replace(" ", "").toLowerCase();
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
        if (resultIndex == -1) {
            throw new BestResultNotFound();
        }
        return searchList.get(resultIndex);
    }

    public String toString() {
        return searchList.toString();
    }
}
