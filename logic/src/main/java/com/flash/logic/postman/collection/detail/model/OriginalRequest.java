package com.flash.logic.postman.collection.detail.model;

import com.google.gson.annotations.SerializedName;


public class OriginalRequest{

    private static final String FIELD_BODY = "body";
    private static final String FIELD_URL = "url";
    private static final String FIELD_HEADER = "header";
    private static final String FIELD_DESCRIPTION = "description";
    private static final String FIELD_METHOD = "method";


    @SerializedName(FIELD_BODY)
    private Object mBody;
    @SerializedName(FIELD_URL)
    private String mUrl;
    @SerializedName(FIELD_HEADER)
    private Header[] mHeaders;
    @SerializedName(FIELD_DESCRIPTION)
    private String mDescription;
    @SerializedName(FIELD_METHOD)
    private String mMethod;


    public OriginalRequest(){

    }

    public void setBody(Object body) {
        mBody = body;
    }

    public Object getBody() {
        return mBody;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setHeaders(Header[] headers) {
        mHeaders = headers;
    }

    public Header[] getHeaders() {
        return mHeaders;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setMethod(String method) {
        mMethod = method;
    }

    public String getMethod() {
        return mMethod;
    }


}