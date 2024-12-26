package org.skypro.skyshop;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {


    @Override
    public int compare(Searchable o1, Searchable o2) {
        int compareLength = Integer.compare(o2.getObjName().length(), o1.getObjName().length());
        if (compareLength != 0) return compareLength;
        else return o1.getObjName().compareTo(o2.getObjName());
    }
}
