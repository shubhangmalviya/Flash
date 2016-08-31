package com.flash;

import com.flash.logic.postman.collection.ErrorResponse;
import com.flash.logic.postman.collection.ResponseCallback;
import com.flash.logic.postman.collection.list.CollectionListingApiRequest;
import com.flash.logic.postman.collection.list.model.ResPostmanCollectionList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PostmanCollectionList implements DisplayPanelLifecycle{
    private JList<String> mCollectionList;
    private JPanel mPanel1;

    public PostmanCollectionList() {
        mCollectionList.setCellRenderer(new PostmanCollectionRenderer());
        mCollectionList.addListSelectionListener(new PostmanCollectionListener());
    }

    private void getCollectionDetail() {
        String apiKey = "e0989dde7ea247c6bb0ba1eeae87a858";

        CollectionListingApiRequest apiRequest = new CollectionListingApiRequest();
        apiRequest.makeRequest(apiKey, new ResPostmanCollectionListResponseCallback());
    }

    public JPanel getFormPanel() {
        return mPanel1;
    }

    @Override
    public void onVisible() {

    }

    @Override
    public void onInvisible() {

    }

    private static class PostmanCollectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {

        }
    }

    private interface PostmanColectionListItemSelectListener {
        void onPostmanCollectionSelected(String postmanId);
    }

    private class ResPostmanCollectionListResponseCallback implements ResponseCallback<ResPostmanCollectionList> {
        public void onSuccess(ResPostmanCollectionList data) {
            DefaultListModel<String> model = new DefaultListModel<>();

            for (int index = 0; index < data.getCollections().length; index ++) {
                model.add(index, data.getCollections()[index].getName());
            }

            mCollectionList.setModel(model);
        }

        public void onFailure(ErrorResponse errorResponse) {
            System.out.print(errorResponse.getMessage());
            if (errorResponse.getThrowable() != null) {
                errorResponse.getThrowable().printStackTrace();
            }
        }
    }
}
