package com.flash.logic.utils;

import org.apache.commons.lang3.StringUtils;

public class NameUtils {

    public String getCapitalised(String name) {
        return name != null ? name.toUpperCase() : null;
    }

    /**
     * user_id = userId, UserId.
     * user/auth/login = userAuthLogin, UserAuthLogin.
     * @param name
     * @param separator the separator to remove
     * @return
     */
    public String getCamelCase(String name, boolean capsFirst, char separator) {

        if (name == null) {
            return null;
        }

        StringBuilder camelCase = new StringBuilder();

        int nextIndex;
        int previousIndex = -1;
        do {
            int fromIndex = previousIndex + 1;
            nextIndex = name.indexOf(separator, fromIndex);
            extractWord(name, capsFirst, camelCase, fromIndex, nextIndex == -1 ? name.length() : nextIndex);
            previousIndex = nextIndex;
        } while (nextIndex != -1);

        return getLegalJavaIdentifier(camelCase.toString());
    }

    private void extractWord(String name, boolean capsFirst, StringBuilder camelCase, int fromIndex, int length) {
        String word = name.substring(fromIndex, length);
        word = (fromIndex != 0 || capsFirst) ? StringUtils.capitalize(word) : word;
        camelCase.append(word);
    }

    public String getLegalJavaIdentifier(String name) {

        String legalIdentifier = "";

        for (int i = 0; i < name.length(); i ++) {
            char c = name.charAt(i);

            if (i != 0 && Character.isJavaIdentifierPart(c)) {
                legalIdentifier += c;
            }else if (i == 0 && Character.isJavaIdentifierStart(c)) {
                legalIdentifier += c;
            }
        }

        if (legalIdentifier.length() == 0) {
            legalIdentifier = "_";
        }

        return legalIdentifier;
    }

}
