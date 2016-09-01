package com.flash.steps;

import com.flash.DisplayPanel;
import com.flash.Step;

import javax.swing.*;
import java.awt.*;

public class IntroductionStep implements Step {

    private final JPanel mMainPanel;
    private final CardLayout mCardLayout;
    private final JRadioButton mIntroductionRadioButton;

    private boolean mIsEnabled;
    private final DisplayPanel mDisplayPanel = DisplayPanel.INTRODUCTION;

    public IntroductionStep(JPanel mainPanel, CardLayout cardLayout, JRadioButton introductionRadioButton) {
        mMainPanel = mainPanel;
        mCardLayout = cardLayout;
        mIntroductionRadioButton = introductionRadioButton;

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

    }

    @Override
    public void makeInvisible() {

    }
}
