package org.skypro.skyshop;

import java.util.Comparator;

public interface Searchable {
    String getSearchTerm();

    String getType();

    String getObjName();

    default String getStringRepresentation() {
        return "Объект " + getObjName() + " типа " + getType();
    }
}
