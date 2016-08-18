package com.flash.logic.postman.collection.detail.model;

import com.google.gson.annotations.SerializedName;


public class FieldIndex{

    private static final String FIELD_LAST_MODIFIED = "lastModified";
    private static final String FIELD_SIZE = "size";
    private static final String FIELD_WEBKIT_RELATIVE_PATH = "webkitRelativePath";
    private static final String FIELD_LAST_MODIFIED_DATE = "lastModifiedDate";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_TYPE = "type";


    @SerializedName(FIELD_LAST_MODIFIED)
    private Long mLastModified;
    @SerializedName(FIELD_SIZE)
    private int mSize;
    @SerializedName(FIELD_WEBKIT_RELATIVE_PATH)
    private String mWebkitRelativePath;
    @SerializedName(FIELD_LAST_MODIFIED_DATE)
    private String mLastModifiedDate;
    @SerializedName(FIELD_NAME)
    private String mName;
    @SerializedName(FIELD_TYPE)
    private String mType;


    public FieldIndex(){

    }

    public void setLastModified(Long lastModified) {
        mLastModified = lastModified;
    }

    public Long getLastModified() {
        return mLastModified;
    }

    public void setSize(int size) {
        mSize = size;
    }

    public int getSize() {
        return mSize;
    }

    public void setWebkitRelativePath(String webkitRelativePath) {
        mWebkitRelativePath = webkitRelativePath;
    }

    public String getWebkitRelativePath() {
        return mWebkitRelativePath;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        mLastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedDate() {
        return mLastModifiedDate;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getType() {
        return mType;
    }


}