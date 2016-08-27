package com.flash.logic;

import com.flash.logic.utils.NameUtils;

public class Flash {

    public static void main(String[] args) {
        NameUtils nameUtils = new NameUtils();
        String testString = nameUtils.getCapitalised("user_id");
        System.out.print(testString);
    }

}