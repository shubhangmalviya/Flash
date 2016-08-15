package com.flash.logic.postman.collection.detail;

import com.google.gson.annotations.SerializedName;


public class Urlencoded{

    private static final String FIELD_KEY = "key";
    private static final String FIELD_ENABLED = "enabled";
    private static final String FIELD_VALUE = "value";
    private static final String FIELD_TYPE = "type";


    @SerializedName(FIELD_KEY)
    private String mKey;
    @SerializedName(FIELD_ENABLED)
    private boolean mEnabled;
    @SerializedName(FIELD_VALUE)
    private String mValue;
    @SerializedName(FIELD_TYPE)
    private String mType;


    public Urlencoded(){

    }

    public void setKey(String key) {
        mKey = key;
    }

    public String getKey() {
        return mKey;
    }

    public void setEnabled(boolean enabled) {
        mEnabled = enabled;
    }

    public boolean isEnabled() {
        return mEnabled;
    }

    public void setValue(String value) {
        mValue = value;
    }

    public String getValue() {
        return mValue;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getType() {
        return mType;
    }


}