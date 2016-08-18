package com.flash.logic.postman.collection.list;

import com.flash.logic.postman.collection.CollectionService;
import com.flash.logic.postman.collection.ResponseCallback;
import com.flash.logic.postman.collection.ResponseWrapper;
import com.flash.logic.postman.collection.ServiceManager;
import com.flash.logic.postman.collection.list.model.ResPostmanCollectionList;
import retrofit2.Call;

public class CollectionListingApiRequest {

    private Call<ResPostmanCollectionList> mResPostmanCollectionListCall;

    public void makeRequest(String apiKey, ResponseCallback<ResPostmanCollectionList> postmanCollectionListCallback) {
        CollectionService collectionService = ServiceManager.get().createService(CollectionService.class);
        mResPostmanCollectionListCall = collectionService.getAllPostmanCollection(apiKey);
        mResPostmanCollectionListCall.enqueue(new ResponseWrapper<ResPostmanCollectionList>(postmanCollectionListCallback));
    }

    public void cancel() {
        mResPostmanCollectionListCall.cancel();
    }


}
