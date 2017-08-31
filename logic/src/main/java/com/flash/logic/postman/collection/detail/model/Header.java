package com.flash.logic.postman.collection.detail.model;

import com.google.gson.annotations.SerializedName;


public class Header{

    private static final String FIELD_KEY = "key";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_VALUE = "value";
    private static final String FIELD_DESCRIPTION = "description";


    @SerializedName(FIELD_KEY)
    private String mKey;
    @SerializedName(FIELD_NAME)
    private String mName;
    @SerializedName(FIELD_VALUE)
    private String mValue;
    @SerializedName(FIELD_DESCRIPTION)
    private String mDescription;


    public Header(){

    }

    public void setKey(String key) {
        mKey = key;
    }

    public String getKey() {
        return mKey;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setValue(String value) {
        mValue = value;
    }

    public String getValue() {
        return mValue;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }


}