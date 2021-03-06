package com.flash.ui;

import com.flash.DisplayPanelLifecycle;

import javax.swing.*;

public class OutputConfigurationUI implements DisplayPanelLifecycle {

    private JTextField mTextFieldPathPostmanCollection;
    private JButton mBtnChoosePostmanCollection;
    private JTextField mTextFieldRequestClassPrefix;
    private JTextField mTextFieldResponseClassPrefix;
    private JRadioButton mGsonRadioButton;
    private JRadioButton mLoganSquareRadioButton;
    private JRadioButton mJacksonRadioButton;
    private JTextField mTextField1;
    private JTextField mTextField2;
    private JTextField mTextField3;
    private JButton mChooseFileButton;
    private JRadioButton mNoneRadioButton;
    private JTextField mTextField4;
    private JTextField mTextField5;
    private JRadioButton mYesRadioButton1;
    private JRadioButton mNoRadioButton1;
    private JRadioButton mYesRadioButton2;
    private JRadioButton mNoRadioButton2;
    private JButton mGenerateSourceButton;
    private JPanel mJPanelMain;
    private JCheckBox mJavaCheckBox;
    private JCheckBox mSwiftCheckBox;


    public static void main(String[] args) {
        JFrame frame = new JFrame("OutputConfigurationUI");
        frame.setContentPane(new OutputConfigurationUI().mJPanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getJPanelMain() {
        return mJPanelMain;
    }

    @Override
    public void onVisible() {

    }

    @Override
    public void onInvisible() {

    }
}
