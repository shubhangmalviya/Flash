package com.flash.steps;

import com.flash.DisplayPanel;
import com.flash.ServiceLayerGenerator;
import com.flash.Step;

import javax.swing.*;
import java.awt.*;

public class OutputConfigurationStep implements Step {
    private final JPanel mMainPanel;
    private final CardLayout mCardLayout;
    private final JRadioButton mOutputConfigurationRadioButton;

    private boolean mIsEnabled;
    private final DisplayPanel mDisplayPanel = DisplayPanel.OUTPUT_CONFIGURATIONS;
    private ServiceLayerGenerator mServiceLayerGenerator = new ServiceLayerGenerator();

    public OutputConfigurationStep(JPanel mainPanel, CardLayout cardLayout, JRadioButton outputConfigurationRadioButton) {
        mMainPanel = mainPanel;
        mCardLayout = cardLayout;
        mOutputConfigurationRadioButton = outputConfigurationRadioButton;

        JPanel jPanelMain = mServiceLayerGenerator.getJPanelMain();
        mainPanel.add(jPanelMain);
        cardLayout.addLayoutComponent(jPanelMain, mDisplayPanel.name());
        outputConfigurationRadioButton.setIcon(new ImageIcon("app/src/assets/ic_enabled.png"));
    }

    @Override
    public boolean isEnabled() {
        return mIsEnabled;
    }

    @Override
    public void enable() {
        mIsEnabled = true;
        mOutputConfigurationRadioButton.setForeground(Color.BLUE);

    }

    @Override
    public void disable() {
        mIsEnabled = false;
        mOutputConfigurationRadioButton.setForeground(Color.BLACK);
    }

    @Override
    public void makeVisible() {
        mCardLayout.show(mMainPanel, mDisplayPanel.name());
        mOutputConfigurationRadioButton.setForeground(Color.BLUE);
        mServiceLayerGenerator.onVisible();
    }

    @Override
    public void makeInvisible() {
        mOutputConfigurationRadioButton.setForeground(Color.BLACK);
        mServiceLayerGenerator.onInvisible();
    }
}
