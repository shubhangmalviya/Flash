package com.flash.logic.postman.collection.detail;

import com.google.gson.annotations.SerializedName;


public class Item{

    private static final String FIELD__POSTMAN_ID = "_postman_id";
    private static final String FIELD_REQUEST = "request";
    private static final String FIELD_RESPONSE = "response";
    private static final String FIELD_NAME = "name";


    @SerializedName(FIELD__POSTMAN_ID)
    private String m_postmanId;
    @SerializedName(FIELD_REQUEST)
    private Request mRequest;
    @SerializedName(FIELD_RESPONSE)
    private Response[] mResponses;
    @SerializedName(FIELD_NAME)
    private String mName;


    public Item(){

    }

    public void set_postmanId(String _postmanId) {
        m_postmanId = _postmanId;
    }

    public String get_postmanId() {
        return m_postmanId;
    }

    public void setRequest(Request request) {
        mRequest = request;
    }

    public Request getRequest() {
        return mRequest;
    }

    public void setResponses(Response[] responses) {
        mResponses = responses;
    }

    public Response[] getResponses() {
        return mResponses;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }


}