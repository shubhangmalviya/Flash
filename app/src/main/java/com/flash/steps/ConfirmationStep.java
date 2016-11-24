package com.flash.steps;

import com.flash.DisplayPanel;
import com.flash.ui.ConfirmationUI;
import com.flash.Step;

import javax.swing.*;
import java.awt.*;

public class ConfirmationStep implements Step {
    private final JPanel mMainPanel;
    private final CardLayout mCardLayout;
    private final JRadioButton mProgrammingRadioButton;

    private boolean mIsEnabled;
    private final DisplayPanel mDisplayPanel = DisplayPanel.CHOOSE_PROGRAMMING_LANGUAGE;
    private ConfirmationUI mConfirmationUI = new ConfirmationUI();

    public ConfirmationStep(JPanel mainPanel, CardLayout cardLayout, JRadioButton programmingLanguage) {
        mMainPanel = mainPanel;
        mCardLayout = cardLayout;
        mProgrammingRadioButton = programmingLanguage;

        JPanel mainPanel1 = mConfirmationUI.getMainPanel();
        mainPanel.add(mainPanel1);
        cardLayout.addLayoutComponent(mainPanel1, mDisplayPanel.name());
        programmingLanguage.setIcon(new ImageIcon("app/src/assets/ic_enabled.png"));
    }

    @Override
    public boolean isEnabled() {
        return mIsEnabled;
    }

    @Override
    public void enable() {
        mIsEnabled = true;
        mProgrammingRadioButton.setForeground(Color.BLUE);

    }

    @Override
    public void disable() {
        mIsEnabled = false;
        mProgrammingRadioButton.setForeground(Color.BLACK);
    }

    @Override
    public void makeVisible() {
        mCardLayout.show(mMainPanel, mDisplayPanel.name());
        mConfirmationUI.onVisible();
    }

    @Override
    public void makeInvisible() {
        mConfirmationUI.onInvisible();
    }
}
