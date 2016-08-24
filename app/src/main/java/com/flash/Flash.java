package com.flash;

import com.flash.logic.postman.collection.ErrorResponse;
import com.flash.logic.postman.collection.ResponseCallback;
import com.flash.logic.postman.collection.detail.DetailApiRequest;
import com.flash.logic.postman.collection.detail.model.ResCollectionDetail;
import com.flash.logic.postman.collection.list.CollectionListingApiRequest;
import com.flash.logic.postman.collection.list.model.ResPostmanCollectionList;

public class Flash {

    public static void main(String[] args) {

//        testCollectionDetail();

        

    }

    private static void testCollectionList() {
        String apiKey = "e0989dde7ea247c6bb0ba1eeae87a858";

        CollectionListingApiRequest apiRequest = new CollectionListingApiRequest();
        apiRequest.makeRequest(apiKey, new ResponseCallback<ResPostmanCollectionList>() {
            public void onSuccess(ResPostmanCollectionList data) {
                System.out.print(data);
            }

            public void onFailure(ErrorResponse errorResponse) {
                System.out.print(errorResponse.getMessage());
                if (errorResponse.getThrowable() != null) {
                    errorResponse.getThrowable().printStackTrace();
                }
            }
        });
    }

    private static void testCollectionDetail() {
        String apiKey = "e0989dde7ea247c6bb0ba1eeae87a858";
        String collectionId = "11fe9412-886c-796a-e6d8-5389759b9b3c";

        DetailApiRequest apiRequest = new DetailApiRequest();
        apiRequest.makeRequest(collectionId, apiKey, new ResponseCallback<ResCollectionDetail>() {
            public void onSuccess(ResCollectionDetail data) {
                System.out.print(data);
            }

            public void onFailure(ErrorResponse errorResponse) {
                System.out.print(errorResponse.getMessage());
                if (errorResponse.getThrowable() != null) {
                    errorResponse.getThrowable().printStackTrace();
                }
            }
        });
    }

}