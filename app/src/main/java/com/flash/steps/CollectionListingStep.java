package com.flash.steps;

import com.flash.DisplayPanel;
import com.flash.ui.CollectionListingUI;
import com.flash.Step;

import javax.swing.*;
import java.awt.*;

public class CollectionListingStep implements Step {

    private final JPanel mMainPanel;
    private final CardLayout mCardLayout;
    private final JRadioButton mCollectionListingRadioButton;

    private boolean mIsEnabled;
    private final DisplayPanel mDisplayPanel = DisplayPanel.POSTMAN_COLLECTIONS_LISTING;
    private CollectionListingUI mCollectionListingUI = new CollectionListingUI();

    public CollectionListingStep(JPanel mainPanel, CardLayout cardLayout, JRadioButton collectionListingRadioButton) {
        mMainPanel = mainPanel;
        mCardLayout = cardLayout;
        mCollectionListingRadioButton = collectionListingRadioButton;

        JPanel formPanel = mCollectionListingUI.getFormPanel();
        mainPanel.add(formPanel);
        cardLayout.addLayoutComponent(formPanel, mDisplayPanel.name());
        collectionListingRadioButton.setIcon(new ImageIcon("app/src/assets/ic_enabled.png"));
    }

    @Override
    public boolean isEnabled() {
        return mIsEnabled;
    }

    @Override
    public void enable() {
        mIsEnabled = true;
        mCollectionListingRadioButton.setForeground(Color.BLUE);

    }

    @Override
    public void disable() {
        mIsEnabled = false;
        mCollectionListingRadioButton.setForeground(Color.BLACK);
    }

    @Override
    public void makeVisible() {
        mCardLayout.show(mMainPanel, mDisplayPanel.name());
        mCollectionListingUI.onVisible();
    }

    @Override
    public void makeInvisible() {
        mCollectionListingUI.onInvisible();
    }
}
