package com.flash;

import javax.swing.*;


public class ProgrammingLanguage implements DisplayPanelLifecycle{
    private JCheckBox mJavaCheckBox;
    private JCheckBox mSwiftCheckBox;
    private JPanel mMainPanel;

    public JPanel getMainPanel() {
        return mMainPanel;
    }

    @Override
    public void onVisible() {

    }

    @Override
    public void onInvisible() {

    }
}
