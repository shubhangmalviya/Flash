package com.flash.ui;

import com.flash.CollectionTreeNodeCreator;
import com.flash.DisplayPanelLifecycle;
import com.flash.logic.postman.batch_request.CollectionFetcher;
import com.flash.logic.postman.batch_request.CollectionMapper;
import com.flash.logic.postman.batch_request.FetchUpdatesListener;
import com.flash.logic.postman.collection.detail.model.Collection;
import com.flash.logic.postman.collection.list.model.CollectionInfo;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.Map;

public class CollectionTree implements DisplayPanelLifecycle{
    private static final String API_KEY = "e0989dde7ea247c6bb0ba1eeae87a858";
    public static final String PROGRESS = "Card2";
    public static final String CONTENT = "Card1";

    private JPanel mContainerPanel;
    private JTree mCollectionTree;
    private JProgressBar mProgressBar;
    private JScrollPane mScrollbar;
    private CardLayout mCardLayout;
    private boolean mIsVisible;
    private CollectionFetcher mCollectionFetcher;


    public CollectionTree() {
        mCollectionFetcher = new CollectionFetcher(API_KEY);
    }

    @Override
    public void onVisible() {
        mIsVisible = true;
        mCardLayout = (CardLayout) mContainerPanel.getLayout();
        mCardLayout.show(mContainerPanel, PROGRESS);
        mProgressBar.setIndeterminate(true);
        mProgressBar.setStringPainted(true);
        mCollectionFetcher.fetch(new CollectionFetchListener());
        mCollectionTree.addTreeSelectionListener(e -> {
            System.out.print("Selected Object " + mCollectionTree.getLastSelectedPathComponent().toString());
        });
    }


    public JPanel getFormPanel() {
        return mContainerPanel;
    }

    @Override
    public void onInvisible() {
        mIsVisible = false;
    }

    private class CollectionFetchListener implements FetchUpdatesListener {
        @Override
        public void onUpdate(String state) {
            mProgressBar.setString(state);
        }

        @Override
        public void onComplete(CollectionMapper collectionMapper) {

            DefaultMutableTreeNode parent = new DefaultMutableTreeNode("Collections");

            for (Map.Entry<CollectionInfo, Collection> collectionEntry : collectionMapper.getCollectionMap().entrySet()) {

                CollectionTreeNodeCreator treeNodeCreator = new CollectionTreeNodeCreator(collectionEntry.getKey(), collectionEntry.getValue());
                DefaultMutableTreeNode node = treeNodeCreator.create();
                parent.add(node);
            }

            DefaultTreeModel treeModel = new DefaultTreeModel(parent);
            treeModel.setAsksAllowsChildren(true);


            mCollectionTree.setModel(new DefaultTreeModel(parent));
            mCardLayout.show(mContainerPanel, CONTENT);
        }

        @Override
        public void onFailure(String message) {
            System.out.print(message);
        }
    }
}
