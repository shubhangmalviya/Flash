package com.flash.logic.postman.collection.detail;

import com.google.gson.annotations.SerializedName;


public class Collection{

    private static final String FIELD_VARIABLES = "variables";
    private static final String FIELD_ITEM = "item";
    private static final String FIELD_INFO = "info";


    @SerializedName(FIELD_VARIABLES)
    private Variable[] mVariables;
    @SerializedName(FIELD_ITEM)
    private Item[] mItems;
    @SerializedName(FIELD_INFO)
    private Info mInfo;


    public Collection(){

    }

    public void setVariables(Variable[] variables) {
        mVariables = variables;
    }

    public Variable[] getVariables() {
        return mVariables;
    }

    public void setItems(Item[] items) {
        mItems = items;
    }

    public Item[] getItems() {
        return mItems;
    }

    public void setInfo(Info info) {
        mInfo = info;
    }

    public Info getInfo() {
        return mInfo;
    }


}