package org.skypro.skyshop;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import java.util.*;


public class SearchEngine {

    private Set<Searchable> searchList;

    public SearchEngine() {
        this.searchList = new HashSet<>();
    }

    public void addItem(Searchable object) {
        searchList.add(object);
    }

    public Set<Searchable> search(String searchTerm) {
        Set<Searchable> results = new TreeSet<>(new SearchableComparator());
        for (Searchable object : searchList) {
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
        Searchable result = null;

        Iterator<Searchable> searchlistIterator = searchList.iterator();
        while (searchlistIterator.hasNext()) {
            for (int i = 0; i < searchList.size(); i++) {
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
        }
        return result;
    }

    public Searchable getBestMatchV2(String search) throws BestResultNotFound {
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
