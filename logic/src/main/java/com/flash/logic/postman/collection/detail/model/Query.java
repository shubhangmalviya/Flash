package com.flash.logic.postman.collection.detail.model;

import com.google.gson.annotations.SerializedName;


public class Query{

    private static final String FIELD_KEY = "key";
    private static final String FIELD_EQUALS = "equals";
    private static final String FIELD_DESCRIPTION = "description";
    private static final String FIELD_VALUE = "value";


    @SerializedName(FIELD_KEY)
    private String mKey;
    @SerializedName(FIELD_EQUALS)
    private boolean mEqual;
    @SerializedName(FIELD_DESCRIPTION)
    private String mDescription;
    @SerializedName(FIELD_VALUE)
    private String mValue;


    public Query(){

    }

    public void setKey(String key) {
        mKey = key;
    }

    public String getKey() {
        return mKey;
    }

    public void setEqual(boolean equal) {
        mEqual = equal;
    }

    public boolean isEqual() {
        return mEqual;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setValue(String value) {
        mValue = value;
    }

    public String getValue() {
        return mValue;
    }


}