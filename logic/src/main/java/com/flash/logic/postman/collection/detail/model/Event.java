package com.flash.logic.postman.collection.detail.model;

import com.google.gson.annotations.SerializedName;


public class Event{

    private static final String FIELD_LISTEN = "listen";
    private static final String FIELD_SCRIPT = "script";


    @SerializedName(FIELD_LISTEN)
    private String mListen;
    @SerializedName(FIELD_SCRIPT)
    private Script mScript;


    public Event(){

    }

    public void setListen(String listen) {
        mListen = listen;
    }

    public String getListen() {
        return mListen;
    }

    public void setScript(Script script) {
        mScript = script;
    }

    public Script getScript() {
        return mScript;
    }


}