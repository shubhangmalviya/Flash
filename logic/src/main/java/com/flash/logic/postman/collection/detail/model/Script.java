package com.flash.logic.postman.collection.detail.model;

import com.google.gson.annotations.SerializedName;


public class Script{

    private static final String FIELD_EXEC = "exec";
    private static final String FIELD_TYPE = "type";


    @SerializedName(FIELD_EXEC)
    private String[] mExecs;
    @SerializedName(FIELD_TYPE)
    private String mType;


    public Script(){

    }

    public void setExecs(String[] execs) {
        mExecs = execs;
    }

    public String[] getExecs() {
        return mExecs;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getType() {
        return mType;
    }


}