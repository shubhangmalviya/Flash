package com.flash.logic.utils;

import org.apache.commons.lang3.StringUtils;

public class NameUtils {

    public String getCapitalised(String name) {
        return name != null ? name.toUpperCase() : null;
    }

    /**
     * user_id = userId, UserId
     * @param name
     * @return
     */
    public String getCamelCase(String name, boolean capsFirst) {

        if (name == null) {
            return null;
        }

        StringBuilder camelCase = new StringBuilder();

        int nextIndex;
        int previousIndex = -1;
        do {
            int fromIndex = previousIndex + 1;
            nextIndex = name.indexOf('_', fromIndex);
            extractWord(name, capsFirst, camelCase, fromIndex, nextIndex == -1 ? name.length() : nextIndex);
            previousIndex = nextIndex;
        } while (nextIndex != -1);

        return camelCase.toString();
    }

    private void extractWord(String name, boolean capsFirst, StringBuilder camelCase, int fromIndex, int length) {
        String word = name.substring(fromIndex, length);
        word = (fromIndex != 0 || capsFirst) ? StringUtils.capitalize(word) : word;
        camelCase.append(word);
    }

}
