package com.flash.ui;

import com.flash.DisplayPanelLifecycle;
import com.flash.logic.postman.batch_request.CollectionFetcher;
import com.flash.logic.postman.batch_request.CollectionMapper;
import com.flash.logic.postman.batch_request.FetchUpdatesListener;
import com.flash.logic.postman.collection.ErrorResponse;
import com.flash.logic.postman.collection.ResponseCallback;
import com.flash.logic.postman.collection.list.CollectionListingApiRequest;
import com.flash.logic.postman.collection.list.model.ResPostmanCollectionList;

import javax.swing.*;

public class CollectionListingUI implements DisplayPanelLifecycle {

    private static final String API_KEY = "e0989dde7ea247c6bb0ba1eeae87a858";

    private JPanel mCollectionListingContainer;
    private JTree mCollectionTree;
    private JProgressBar progressBar1;
    private JPanel mCollectionContainer;

    public CollectionListingUI() {
    }

    private void getCollectionDetail() {
        CollectionListingApiRequest apiRequest = new CollectionListingApiRequest();
        apiRequest.makeRequest(API_KEY, new ResPostmanCollectionListResponseCallback());
    }

    public JPanel getFormPanel() {
        return mCollectionListingContainer;
    }

    @Override
    public void onVisible() {
        getCollectionDetail();
    }

    @Override
    public void onInvisible() {

    }

    private class ResPostmanCollectionListResponseCallback implements ResponseCallback<ResPostmanCollectionList> {
        public void onSuccess(ResPostmanCollectionList data) {

        }

        public void onFailure(ErrorResponse errorResponse) {
            System.out.print(errorResponse.getMessage());
            if (errorResponse.getThrowable() != null) {
                errorResponse.getThrowable().printStackTrace();
            }
        }
    }
}
