package com.flash.logic.postman.collection;

import com.flash.logic.postman.collection.list.model.ResPostmanCollectionList;

public interface ApiRequest<T> {

    void makeRequest(ResponseCallback<T> postmanCollectionListCallback);

}
