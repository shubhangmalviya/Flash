package com.flash.ui;

import com.flash.CollectionTreeNodeCreator;
import com.flash.DisplayPanelLifecycle;
import com.flash.logic.postman.batch_request.CollectionFetcher;
import com.flash.logic.postman.batch_request.CollectionMapper;
import com.flash.logic.postman.batch_request.FetchUpdatesListener;
import com.flash.logic.postman.collection.detail.model.Collection;
import com.flash.logic.postman.collection.detail.model.Item;
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


    @Override
    public void onVisible() {
        mCardLayout = (CardLayout) mContainerPanel.getLayout();
        mCardLayout.show(mContainerPanel, PROGRESS);
        mProgressBar.setIndeterminate(true);

        new CollectionFetcher(API_KEY).fetch(new FetchUpdatesListener() {
            @Override
            public void onUpdate(String state) {
                System.out.print(state);
            }

            @Override
            public void onComplete(CollectionMapper collectionMapper) {

                DefaultMutableTreeNode parent = new DefaultMutableTreeNode();

                for (Map.Entry<CollectionInfo, Collection> collectionEntry : collectionMapper.getCollectionMap().entrySet()) {

                    CollectionTreeNodeCreator treeNodeCreator = new CollectionTreeNodeCreator(collectionEntry.getKey(), collectionEntry.getValue());
                    DefaultMutableTreeNode node = treeNodeCreator.create();
                    parent.add(node);
                }

                mCollectionTree.setModel(new DefaultTreeModel(parent));
//                mCollectionTree.setCellRenderer(new CollectionCellRenderer());

                mCardLayout.show(mContainerPanel, CONTENT);
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

    private class CollectionCellRenderer extends DefaultTreeCellRenderer {
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value,
                                                      boolean selected, boolean expanded,
                                                      boolean leaf, int row, boolean hasFocus) {

            Component component = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

            String name = "";

            Object model = ((DefaultMutableTreeNode) value).getUserObject();

            if (model instanceof CollectionInfo) {
                name = ((CollectionInfo) model).getName();
            }else if (model instanceof Item) {
                name = ((Item) model).getName();
            }

            component.setName(name);

            return component;
        }
    }
}
