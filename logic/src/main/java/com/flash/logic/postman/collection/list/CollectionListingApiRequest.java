package com.flash.logic.postman.collection.list;

import com.flash.logic.postman.collection.*;
import com.flash.logic.postman.collection.list.model.ResPostmanCollectionList;
import retrofit2.Call;

public class CollectionListingApiRequest implements ApiRequest<ResPostmanCollectionList>{

    private Call<ResPostmanCollectionList> mResPostmanCollectionListCall;
    private String mApiKey;

    public CollectionListingApiRequest() {
    }

    public CollectionListingApiRequest(String apiKey) {
        mApiKey = apiKey;
    }

    public void makeRequest(String apiKey, ResponseCallback<ResPostmanCollectionList> postmanCollectionListCallback) {
        CollectionService collectionService = ServiceManager.get().createService(CollectionService.class);
        mResPostmanCollectionListCall = collectionService.getAllPostmanCollection(apiKey);
        mResPostmanCollectionListCall.enqueue(new ResponseWrapper<>(postmanCollectionListCallback));
    }

    public void cancel() {
        mResPostmanCollectionListCall.cancel();
    }


    @Override
    public void makeRequest(ResponseCallback<ResPostmanCollectionList> postmanCollectionListCallback) {
        CollectionService collectionService = ServiceManager.get().createService(CollectionService.class);
        mResPostmanCollectionListCall = collectionService.getAllPostmanCollection(mApiKey);
        mResPostmanCollectionListCall.enqueue(new ResponseWrapper<>(postmanCollectionListCallback));
    }
}
