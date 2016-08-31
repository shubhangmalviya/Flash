package com.flash;

import javax.swing.*;

public class PostmanAPIKeyUI implements DisplayPanelLifecycle{
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
