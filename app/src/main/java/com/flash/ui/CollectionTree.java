package com.flash.ui;

import com.flash.DisplayPanelLifecycle;
import com.flash.logic.postman.batch_request.CollectionFetcher;
import com.flash.logic.postman.batch_request.CollectionMapper;
import com.flash.logic.postman.batch_request.FetchUpdatesListener;

import javax.swing.*;
import java.awt.*;

public class CollectionTree implements DisplayPanelLifecycle{
    private static final String API_KEY = "e0989dde7ea247c6bb0ba1eeae87a858";

    private JPanel mContainerPanel;
    private JTree mCollectionTree;
    private JProgressBar mProgressBar;
    private JScrollPane mScrollbar;
    private CardLayout mCardLayout;


    @Override
    public void onVisible() {
        mCardLayout = (CardLayout) mContainerPanel.getLayout();
        mCardLayout.show(mContainerPanel, "Card2");
        mProgressBar.setIndeterminate(true);
        new CollectionFetcher(API_KEY).fetch(new FetchUpdatesListener() {
            @Override
            public void onUpdate(String state) {
                System.out.print(state);
            }

            @Override
            public void onComplete(CollectionMapper collectionMapper) {
                System.out.print("");
            }

            @Override
            public void onFailure(String message) {
                System.out.print(message);
            }
        });
    }


    public JPanel getFormPanel() {
        return mContainerPanel;
    }

    @Override
    public void onInvisible() {

    }
}
