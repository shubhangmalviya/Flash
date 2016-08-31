package com.flash;

import javax.swing.*;

public class ServiceLayerGenerator implements DisplayPanelLifecycle{

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
    private JTextField mTextField6;
    private JButton mGenerateSourceButton;
    private JPanel mJPanelMain;


    public static void main(String[] args) {
        JFrame frame = new JFrame("ServiceLayerGenerator");
        frame.setContentPane(new ServiceLayerGenerator().mJPanelMain);
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
