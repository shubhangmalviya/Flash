package com.flash.logic.postman.collection.detail;

import com.flash.logic.postman.collection.CollectionService;
import com.flash.logic.postman.collection.ResponseCallback;
import com.flash.logic.postman.collection.ResponseWrapper;
import com.flash.logic.postman.collection.ServiceManager;
import com.flash.logic.postman.collection.detail.model.ResCollectionDetail;
import retrofit2.Call;

public class DetailApiRequest {

    private Call<ResCollectionDetail> mCollectionDetailCall;

    public void makeRequest(String collectionId, String apiKey, ResponseCallback<ResCollectionDetail> reaponseCollectionDetail) {
        CollectionService service = ServiceManager.get().createService(CollectionService.class);
        mCollectionDetailCall = service.getPostmanCollectionDetails(collectionId, apiKey);
        mCollectionDetailCall.enqueue(new ResponseWrapper<ResCollectionDetail>(reaponseCollectionDetail));
    }

    public void cancel() {
        mCollectionDetailCall.cancel();
    }

}
