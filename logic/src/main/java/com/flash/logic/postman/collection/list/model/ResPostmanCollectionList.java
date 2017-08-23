package com.flash.logic.postman.collection.list.model;

import com.google.gson.annotations.SerializedName;


public class ResPostmanCollectionList {

    private static final String FIELD_COLLECTIONS = "collections";


    @SerializedName(FIELD_COLLECTIONS)
    private CollectionInfo[] mCollectionInfos;


    public ResPostmanCollectionList(){

    }

    public void setCollections(CollectionInfo[] collectionInfos) {
        mCollectionInfos = collectionInfos;
    }

    public CollectionInfo[] getCollections() {
        return mCollectionInfos;
    }


}