package com.flash.ui;

import com.flash.Step;
import com.flash.StepsManager;
import com.flash.steps.*;

import javax.swing.*;
import java.awt.*;


public class FlashMainUI {
    private JSplitPane mFlashSplitPane;
    private JRadioButton mIntroductionRadioButton;
    private JRadioButton mCollectionSourceRadioButton;
    private JRadioButton mCollectionListingRadioButton;
    private JRadioButton mOutputConfigurationRadioButton;
    private JRadioButton mConfirmationRadioButton;
    private JPanel mMainContent;
    private JPanel mCreationProgress;
    private JPanel mFlashPanel;
    private JPanel mLogoImage;
    private JButton mPreviousButton;
    private JButton mNextButton;
    private final StepsManager mStepsManager;


    public static void main(String[] args) {
        JFrame frame = new JFrame("FlashMainUI");
        frame.setContentPane(new FlashMainUI().mFlashPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("app/src/assets/ic_enabled.png").getImage());
        frame.setTitle("Flash IDE");
        frame.pack();
        frame.setVisible(true);
    }

    public FlashMainUI() {
        setLogoImage();
        final CardLayout cardLayout = (CardLayout) mMainContent.getLayout();

        Step introduction = new IntroductionStep(mMainContent,cardLayout, mIntroductionRadioButton);
        Step collectionSource = new CollectionSourceStep(mMainContent,cardLayout, mCollectionSourceRadioButton);
        Step collectionListing = new CollectionListingStep(mMainContent,cardLayout, mCollectionListingRadioButton);
        Step outputConfiguration = new OutputConfigurationStep(mMainContent,cardLayout, mOutputConfigurationRadioButton);
        Step confirmationStep = new ConfirmationStep(mMainContent,cardLayout, mConfirmationRadioButton);

        mStepsManager = new StepsManager();
        mStepsManager.registerStep(collectionSource);
        mStepsManager.registerStep(collectionListing);
        mStepsManager.registerStep(outputConfiguration);
        mStepsManager.registerStep(confirmationStep);

        mStepsManager.resetAllSteps();

        mConfirmationRadioButton.addItemListener(e -> mStepsManager.jumpToStep(confirmationStep));
        mCollectionSourceRadioButton.addItemListener(e -> mStepsManager.jumpToStep(collectionSource));
        mCollectionListingRadioButton.addItemListener(e -> mStepsManager.jumpToStep(collectionListing));
        mOutputConfigurationRadioButton.addItemListener(e -> mStepsManager.jumpToStep(outputConfiguration));

        mPreviousButton.addActionListener(a -> mStepsManager.moveToPrevious());
        mNextButton.addActionListener(a -> mStepsManager.moveToNext());

    }

    private void setLogoImage() {
        ImageIcon defaultIcon = new ImageIcon("app/src/assets/flash_logo.png");
        JLabel comp = new JLabel(defaultIcon);
        mLogoImage.add(comp, BorderLayout.CENTER);
    }
}
