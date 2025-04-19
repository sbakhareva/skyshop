package org.skypro.skyshop;

public interface Searchable {
    String getSearchTerm();

    String getType();

    String getObjName();

    default String getStringRepresentation() {
        return "Объект " + getObjName() + " типа " + getType();
    }
}
