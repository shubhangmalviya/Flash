package com.flash.logic.postman.collection.detail.model;

import com.google.gson.annotations.SerializedName;


public class ResCollectionDetail {

    private static final String FIELD_COLLECTION = "collection";


    @SerializedName(FIELD_COLLECTION)
    private Collection mCollection;


    public ResCollectionDetail(){

    }

    public void setCollection(Collection collection) {
        mCollection = collection;
    }

    public Collection getCollection() {
        return mCollection;
    }


}