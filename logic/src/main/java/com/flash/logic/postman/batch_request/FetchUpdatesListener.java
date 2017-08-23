package com.flash.logic.postman.batch_request;

public interface FetchUpdatesListener {

    void onUpdate(String state);

    void onComplete(CollectionMapper collectionMapper);

    void onFailure(String message);

}
