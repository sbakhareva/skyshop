package org.skypro.skyshop;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import java.util.*;


public class SearchEngine {

    HashSet<Searchable> searchList;

    public SearchEngine() {
        this.searchList = new HashSet<>();
    }

    public void addItem(Searchable object) {
        searchList.add(object);
    }

    public TreeSet<Searchable> search(String searchTerm) {
        TreeSet<Searchable> results = new TreeSet<>(new SearchableComparator());
        for (Searchable object : searchList) {
            if (object.getSearchTerm().toLowerCase().replace(" ", "").
                    contains(searchTerm.toLowerCase().replace(" ", ""))) {
                results.add(object);
            }
        }
        return results;
    }

    public Searchable getBestMatch(String search) throws BestResultNotFound {
        List<Searchable> objects = new ArrayList<>(searchList);
        String substring = search.replace(" ", "").toLowerCase();
        int countSubstringLast = 0;
        int resultIndex = -1;

        Iterator<Searchable> searchlistIterator = searchList.iterator();
        while (searchlistIterator.hasNext()) {
            for (int i = 0; i < searchList.size(); i++) {
                String text = searchlistIterator.next().getSearchTerm().replace(" ", "").toLowerCase();
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
        }
        return objects.get(resultIndex);
    }

    public String toString() {
        return searchList.toString();
    }
}
