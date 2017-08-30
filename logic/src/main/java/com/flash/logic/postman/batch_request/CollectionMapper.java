package com.flash.logic.postman.batch_request;

import com.flash.logic.postman.collection.detail.model.Collection;
import com.flash.logic.postman.collection.list.model.CollectionInfo;

import java.util.HashMap;
import java.util.Map;

public class CollectionMapper {
    private Map<CollectionInfo, Collection> mCollectionMap = new HashMap<>();

    protected void setCollectionInfo(CollectionInfo[] infos) {
        if (infos == null || infos.length == 0) {
            return;
        }

        for (CollectionInfo collectionInfo : infos) {
            mCollectionMap.put(collectionInfo, null);
        }
    }

    protected void setCollection(CollectionInfo collectionInfo, Collection collections) {

        if (!mCollectionMap.containsKey(collectionInfo)) {
            throw new IllegalArgumentException("The CollectionInfo is not found");
        }

        mCollectionMap.put(collectionInfo, collections);
    }

    public Map<CollectionInfo, Collection> getCollectionMap() {
        return mCollectionMap;
    }
}
