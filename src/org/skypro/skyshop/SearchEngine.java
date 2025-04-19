package org.skypro.skyshop;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;


public class SearchEngine {

    private Set<Searchable> searchList;

    public SearchEngine() {
        this.searchList = new HashSet<>();
    }

    public void addItem(Searchable object) {
        searchList.add(object);
    }

    public Set<Searchable> search(String searchTerm) {
        return searchList.stream()
                .filter(searchable -> searchable.getSearchTerm().toLowerCase().replace(" ", "")
                        .contains(searchTerm.toLowerCase().replace(" ", "")))
                .collect(Collectors.toCollection((() -> new TreeSet<>(new SearchableComparator()))));
    }


    public Searchable getBestMatch(String search) throws BestResultNotFound {
        String substring = search.replace(" ", "").toLowerCase();
        int countSubstringLast = 0;
        Searchable result = null;

        Iterator<Searchable> searchlistIterator = searchList.iterator();
        while (searchlistIterator.hasNext()) {
            Searchable searchable = searchlistIterator.next();
            String text = searchable.getSearchTerm().replace(" ", "").toLowerCase();
            int counter = 0;
            int index = 0;

            while ((index = text.indexOf(substring, index)) != -1) {
                counter++;
                index = index + substring.length();
            }
            if (counter > countSubstringLast) {
                countSubstringLast = counter;
                result = searchable;
            }
        }
        if (result == null) {
            throw new BestResultNotFound();
        }
        return result;
    }

    public String toString() {
        return searchList.toString();
    }
}
