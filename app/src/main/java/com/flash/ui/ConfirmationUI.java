package com.flash.ui;

import com.flash.DisplayPanelLifecycle;

import javax.swing.*;


public class ConfirmationUI implements DisplayPanelLifecycle {
    private JPanel mMainPanel;
    private JLabel mFlashLogo;
    private JLabel mSourceGenerated;


    public JPanel getMainPanel() {
        return mMainPanel;
    }

    @Override
    public void onVisible() {
        mFlashLogo.setIcon(new ImageIcon("app/src/assets/confirmation.png"));
    }

    @Override
    public void onInvisible() {

    }
}
