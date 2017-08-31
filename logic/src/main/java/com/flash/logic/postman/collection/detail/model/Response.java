package com.flash.logic.postman.collection.detail.model;

import com.google.gson.annotations.SerializedName;


public class Response{

    private static final String FIELD_BODY = "body";
    private static final String FIELD_RESPONSE_TIME = "responseTime";
    private static final String FIELD_STATUS = "status";
    private static final String FIELD_HEADER = "header";
    private static final String FIELD_ID = "id";
    private static final String FIELD_CODE = "code";
    private static final String FIELD_COOKIE = "cookie";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_ORIGINAL_REQUEST = "originalRequest";

    @SerializedName(FIELD_BODY)
    private String mBody;
    @SerializedName(FIELD_RESPONSE_TIME)
    private String mResponseTime;
    @SerializedName(FIELD_STATUS)
    private String mStatus;
    @SerializedName(FIELD_HEADER)
    private Header[] mHeaders;
    @SerializedName(FIELD_ID)
    private String mId;
    @SerializedName(FIELD_CODE)
    private int mCode;
    @SerializedName(FIELD_COOKIE)
    private Cookie[] mCookies;
    @SerializedName(FIELD_NAME)
    private String mName;
    @SerializedName(FIELD_ORIGINAL_REQUEST)
    private OriginalRequest mOriginalRequest;


    public Response(){

    }

    public void setBody(String body) {
        mBody = body;
    }

    public String getBody() {
        return mBody;
    }

    public void setResponseTime(String responseTime) {
        mResponseTime = responseTime;
    }

    public String getResponseTime() {
        return mResponseTime;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setHeaders(Header[] headers) {
        mHeaders = headers;
    }

    public Header[] getHeaders() {
        return mHeaders;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }

    public void setCode(int code) {
        mCode = code;
    }

    public int getCode() {
        return mCode;
    }

    public void setCookies(Cookie[] cookies) {
        mCookies = cookies;
    }

    public Cookie[] getCookies() {
        return mCookies;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setOriginalRequest(OriginalRequest originalRequest) {
        mOriginalRequest = originalRequest;
    }

    public OriginalRequest getOriginalRequest() {
        return mOriginalRequest;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Response){
            return ((Response) obj).getId() == mId;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return mId.hashCode();
    }


}