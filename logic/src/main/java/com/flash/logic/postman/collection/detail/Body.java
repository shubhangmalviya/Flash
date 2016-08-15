package com.flash.logic.postman.collection.detail;

import com.google.gson.annotations.SerializedName;


public class Body{

    private static final String FIELD_URLENCODED = "urlencoded";
    private static final String FIELD_MODE = "mode";
    private static final String FIELD_FORMDATA = "formdata";


    @SerializedName(FIELD_URLENCODED)
    private Urlencoded[] mUrlencodeds;
    @SerializedName(FIELD_MODE)
    private String mMode;
    @SerializedName(FIELD_FORMDATA)
    private Formdatum[] mFormdata;


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

    public void setFormdata(Formdatum[] formdata) {
        mFormdata = formdata;
    }

    public Formdatum[] getFormdata() {
        return mFormdata;
    }


}