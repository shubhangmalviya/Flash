package com.flash.logic.postman.collection.detail;

import com.google.gson.annotations.SerializedName;


public class Value{

    private static final String FIELD_INDEX = "0";
    private static final String FIELD_LENGTH = "length";


    @SerializedName(FIELD_INDEX)
    private FieldIndex mFieldIndex;
    @SerializedName(FIELD_LENGTH)
    private int mLength;


    public Value(){

    }

    public void setFieldIndex(FieldIndex v0) {
        mFieldIndex = v0;
    }

    public FieldIndex getFieldIndex() {
        return mFieldIndex;
    }

    public void setLength(int length) {
        mLength = length;
    }

    public int getLength() {
        return mLength;
    }


}