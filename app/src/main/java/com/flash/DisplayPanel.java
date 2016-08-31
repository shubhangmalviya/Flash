package com.flash;

public enum DisplayPanel {
    INTRODUCTION("INTRODUCTION"),
    POSTMAN_COLLECTION_SOURCE("POSTMAN_COLLECTION_SOURCE"),
    CHOOSE_PROGRAMMING_LANGUAGE("CHOOSE_PROGRAMMING_LANGUAGE"),
    POSTMAN_COLLECTIONS_LISTING("POSTMAN_COLLECTIONS_LISTING"),
    OUTPUT_CONFIGURATIONS("OUTPUT_CONFIGURATIONS");

    private final String mName;

    DisplayPanel(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }
}
