package com.flash.logic.postman.collection.detail;

import com.flash.logic.postman.collection.*;
import com.flash.logic.postman.collection.detail.model.ResCollectionDetail;
import retrofit2.Call;

public class DetailApiRequest implements ApiRequest<ResCollectionDetail> {

    private Call<ResCollectionDetail> mCollectionDetailCall;
    private String mCollectionId;
    private String mApiKey;

    public DetailApiRequest(String collectionId, String apiKey) {
        mApiKey = apiKey;
        mCollectionId = collectionId;
    }

    public DetailApiRequest() {
    }

    public void makeRequest(String collectionId, String apiKey, ResponseCallback<ResCollectionDetail> reaponseCollectionDetail) {
        CollectionService service = ServiceManager.get().createService(CollectionService.class);
        mCollectionDetailCall = service.getPostmanCollectionDetails(collectionId, apiKey);
        mCollectionDetailCall.enqueue(new ResponseWrapper<>(reaponseCollectionDetail));
    }

    public void cancel() {
        mCollectionDetailCall.cancel();
    }

    @Override
    public void makeRequest(ResponseCallback<ResCollectionDetail> responseCollectionDetail) {
        CollectionService service = ServiceManager.get().createService(CollectionService.class);
        mCollectionDetailCall = service.getPostmanCollectionDetails(mCollectionId, mApiKey);
        mCollectionDetailCall.enqueue(new ResponseWrapper<>(responseCollectionDetail));
    }
}
