package com.flash.logic.postman.collection.list.model;

import com.google.gson.annotations.SerializedName;


public class CollectionInfo {

    private static final String FIELD_UID = "uid";
    private static final String FIELD_OWNER = "owner";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";


    @SerializedName(FIELD_UID)
    private String mUid;
    @SerializedName(FIELD_OWNER)
    private int mOwner;
    @SerializedName(FIELD_ID)
    private String mId;
    @SerializedName(FIELD_NAME)
    private String mName;


    public CollectionInfo(){

    }

    public void setUid(String uid) {
        mUid = uid;
    }

    public String getUid() {
        return mUid;
    }

    public void setOwner(int owner) {
        mOwner = owner;
    }

    public int getOwner() {
        return mOwner;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof CollectionInfo){
            return ((CollectionInfo) obj).getUid() == mUid;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return mId.hashCode();
    }

    @Override
    public String toString() {
        return  mName;
    }
}