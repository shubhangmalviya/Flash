package com.flash.ui;

import com.flash.DisplayPanelLifecycle;

import javax.swing.*;

public class CollectionSourceUI implements DisplayPanelLifecycle {
    private JTextField mPostManApiKeyText;
    private JLabel mPostmanAPIKey;
    private JPanel mPostmanFormPanel;

    public JPanel getPostmanFormPanel() {
        return mPostmanFormPanel;
    }

    @Override
    public void onVisible() {

    }

    @Override
    public void onInvisible() {

    }
}
