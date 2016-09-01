package com.flash;

import javax.swing.*;


public class Confirmation implements DisplayPanelLifecycle{
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
