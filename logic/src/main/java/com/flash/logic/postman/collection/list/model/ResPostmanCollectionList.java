package com.flash.logic.postman.collection.list.model;

import com.google.gson.annotations.SerializedName;


public class ResPostmanCollectionList {

    private static final String FIELD_COLLECTIONS = "collections";


    @SerializedName(FIELD_COLLECTIONS)
    private Collection[] mCollections;


    public ResPostmanCollectionList(){

    }

    public void setCollections(Collection[] collections) {
        mCollections = collections;
    }

    public Collection[] getCollections() {
        return mCollections;
    }


}