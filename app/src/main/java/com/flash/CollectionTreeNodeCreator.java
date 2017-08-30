package com.flash;

import com.flash.logic.postman.collection.detail.model.Collection;
import com.flash.logic.postman.collection.detail.model.Item;
import com.flash.logic.postman.collection.list.model.CollectionInfo;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class CollectionTreeNodeCreator {

    private final CollectionInfo mCollectionInfo;
    private final Collection mCollection;

    public CollectionTreeNodeCreator(CollectionInfo collectionInfo, Collection collection) {
        mCollectionInfo = collectionInfo;
        mCollection = collection;
    }

    public DefaultMutableTreeNode create() {

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(mCollectionInfo);

        constructNode(root, mCollection.getItems());

        return root;
    }

    private void constructNode(DefaultMutableTreeNode parent, Item[] items) {

        for (Item item : items) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(item);
            parent.add(node);
            if (item.getItems() != null) {
                constructNode(node, item.getItems());
            }
        }
    }
}
