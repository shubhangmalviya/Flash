package com.flash;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class FlashMainUI {
    private JSplitPane mFlashSplitPane;
    private JRadioButton mIntroductionRadioButton;
    private JRadioButton mEnterAPIKeyRadioButton;
    private JRadioButton mChooseLanguageRadioButton;
    private JRadioButton mConfigureRadioButton;
    private JRadioButton mConfirmationRadioButton;
    private JPanel mMainContent;
    private JPanel mCreationProgress;
    private JPanel mFlashPanel;


    public static void main(String[] args) {
        JFrame frame = new JFrame("FlashMainUI");
        frame.setContentPane(new FlashMainUI().mFlashPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public FlashMainUI() {

        final CardLayout cardLayout = (CardLayout) mMainContent.getLayout();
        cardLayout.addLayoutComponent(getPostmanAPIKeyForm(), "postman_api");
        cardLayout.addLayoutComponent(getPostmanCollectionListForm(), "collection_list_api");
        cardLayout.addLayoutComponent(getProgramingLanguageForm(), "lang");
        cardLayout.addLayoutComponent(getGeneratorConfigurationForm(), "gen");

        mEnterAPIKeyRadioButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                cardLayout.show(mMainContent, "postman_api");
            }
        });
        mChooseLanguageRadioButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                cardLayout.show(mMainContent, "lang");
            }
        });
        mConfigureRadioButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                cardLayout.show(mMainContent, "gen");
            }
        });

    }

    private JPanel getPostmanAPIKeyForm() {
        JPanel postmanFormPanel = new PostmanAPIKeyUI().getPostmanFormPanel();
        mMainContent.add(postmanFormPanel);
        return postmanFormPanel;
    }

    private JPanel getPostmanCollectionListForm() {
        JPanel formPanel = new PostmanCollectionList().getFormPanel();
        mMainContent.add(formPanel);
        return formPanel;
    }

    private JPanel getProgramingLanguageForm() {
        JPanel mainPanel = new ProgrammingLanguage().getMainPanel();
        mMainContent.add(mainPanel);
        return mainPanel;
    }

    private JPanel getGeneratorConfigurationForm() {
        JPanel jPanelMain = new ServiceLayerGenerator().getJPanelMain();
        mMainContent.add(jPanelMain);
        return jPanelMain;
    }


}
