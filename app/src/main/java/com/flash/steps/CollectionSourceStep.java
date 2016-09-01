package com.flash.steps;

import com.flash.DisplayPanel;
import com.flash.PostmanAPIKeyUI;
import com.flash.Step;

import javax.swing.*;
import java.awt.*;

public class CollectionSourceStep implements Step {
    private final JPanel mMainPanel;
    private final CardLayout mCardLayout;
    private final JRadioButton mIntroductionRadioButton;

    private boolean mIsEnabled;
    private final DisplayPanel mDisplayPanel = DisplayPanel.POSTMAN_COLLECTION_SOURCE;
    private PostmanAPIKeyUI mPostmanAPIKeyUI = new PostmanAPIKeyUI();

    public CollectionSourceStep(JPanel mainPanel, CardLayout cardLayout, JRadioButton introductionRadioButton) {
        mMainPanel = mainPanel;
        mCardLayout = cardLayout;
        mIntroductionRadioButton = introductionRadioButton;

        JPanel postmanFormPanel = mPostmanAPIKeyUI.getPostmanFormPanel();
        mainPanel.add(postmanFormPanel);
        cardLayout.addLayoutComponent(postmanFormPanel, mDisplayPanel.name());
        introductionRadioButton.setIcon(new ImageIcon("app/src/assets/ic_enabled.png"));
    }

    @Override
    public boolean isEnabled() {
        return mIsEnabled;
    }

    @Override
    public void enable() {
        mIsEnabled = true;
        mIntroductionRadioButton.setForeground(Color.BLUE);

    }

    @Override
    public void disable() {
        mIsEnabled = false;
        mIntroductionRadioButton.setForeground(Color.BLACK);
    }

    @Override
    public void makeVisible() {
        mCardLayout.show(mMainPanel, mDisplayPanel.name());
        mPostmanAPIKeyUI.onVisible();
    }

    @Override
    public void makeInvisible() {
        mPostmanAPIKeyUI.onInvisible();
    }
}
