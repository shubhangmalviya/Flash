package com.flash.logic.postman.collection.detail.model;

import com.google.gson.annotations.SerializedName;


public class Body{

    private static final String FIELD_URLENCODED = "urlencoded";
    private static final String FIELD_MODE = "mode";
    private static final String FIELD_RAW = "raw";
    private static final String FIELD_FORMDATA = "formdata";


    @SerializedName(FIELD_URLENCODED)
    private Urlencoded[] mUrlencodeds;
    @SerializedName(FIELD_MODE)
    private String mMode;
    @SerializedName(FIELD_RAW)
    private String mRaw;
    @SerializedName(FIELD_FORMDATA)
    private Formdata[] mFormdata;


    public Body(){

    }

    public void setUrlencodeds(Urlencoded[] urlencodeds) {
        mUrlencodeds = urlencodeds;
    }

    public Urlencoded[] getUrlencodeds() {
        return mUrlencodeds;
    }

    public void setMode(String mode) {
        mMode = mode;
    }

    public String getMode() {
        return mMode;
    }

    public void setRaw(String raw) {
        mRaw = raw;
    }

    public String getRaw() {
        return mRaw;
    }

    public void setFormdata(Formdata[] formdata) {
        mFormdata = formdata;
    }

    public Formdata[] getFormdata() {
        return mFormdata;
    }


}