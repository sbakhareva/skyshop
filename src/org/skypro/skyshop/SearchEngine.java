package org.skypro.skyshop;

import com.sun.source.tree.Tree;
import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;


public class SearchEngine {

    Set<Searchable> searchList;

    public SearchEngine() {
        this.searchList = new HashSet<>();
    }

    public void addItem(Searchable object) {
        searchList.add(object);
    }

    public Set<Searchable> search(String searchTerm) {
        Set<Searchable> results = new TreeSet<>();
        Iterator<Searchable> searchlistIterator = searchList.iterator();
        while (searchlistIterator.hasNext()) {
            Searchable object = searchlistIterator.next();
            if (object.getSearchTerm().toLowerCase().replace(" ", "").
                    contains(searchTerm.toLowerCase().replace(" ", ""))) {
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
