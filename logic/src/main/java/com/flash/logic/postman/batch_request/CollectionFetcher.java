package com.flash.logic.postman.batch_request;

import com.flash.logic.postman.collection.ErrorResponse;
import com.flash.logic.postman.collection.ResponseCallback;
import com.flash.logic.postman.collection.list.CollectionListingApiRequest;
import com.flash.logic.postman.collection.list.model.ResPostmanCollectionList;

public class CollectionFetcher {

    private String mApiKey;
    private CollectionMapper mCollectionMapper;
    private FetchUpdatesListener mListener;

    public CollectionFetcher(String apiKey) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("Invalid API Key! API key cannot be null or empty");
        }

        mApiKey = apiKey;
        mCollectionMapper = new CollectionMapper();
    }

    /**
     * Starts a process to fetch all the colelctions from the postman.
     * @param listener the subscriber of the updates.
     */
    public void fetch(FetchUpdatesListener listener) {
        mListener = listener;
        publishProgress(listener);
        CollectionListingApiRequest apiRequest = new CollectionListingApiRequest();
        apiRequest.makeRequest(mApiKey, new CollectionListingResponse());
    }

    /**
     * Publishes the progress to the subscriber, does nothing if the parameter is null.
     * @param listener the subscriber of updates.
     */
    private void publishProgress(FetchUpdatesListener listener) {
        if (listener != null) {
            listener.onUpdate("Fetching the collection listing..");
        }
    }
    /**
     * Publishes the success to the subscriber, does nothing if the parameter is null.
     * @param listener the subscriber of updates.
     */
    private void publishSuccess(FetchUpdatesListener listener) {
        if (listener != null) {
            listener.onComplete(mCollectionMapper);
        }
    }
    /**
     * Publishes the failure to the subscriber, does nothing if the parameter is null.
     * @param listener the subscriber of updates.
     */
    private void publishFailure(FetchUpdatesListener listener, String errorMsg) {
        if (listener != null) {
            listener.onFailure(errorMsg);
        }
    }

    private class CollectionListingResponse implements ResponseCallback<ResPostmanCollectionList> {

        @Override
        public void onSuccess(ResPostmanCollectionList data) {

            if (data.getCollections() == null || data.getCollections().length == 0) {
                publishFailure(mListener,"No collection found");
            }

            mCollectionMapper.setCollectionInfo(data.getCollections());
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
            publishFailure(mListener, errorResponse.getMessage());
        }
    }
}
