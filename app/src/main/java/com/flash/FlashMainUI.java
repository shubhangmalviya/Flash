package com.flash;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;


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
    private JPanel mLogoImage;
    private JButton mCancelButton;
    private JButton mNextButton;


    public static void main(String[] args) {
        JFrame frame = new JFrame("FlashMainUI");
        frame.setContentPane(new FlashMainUI().mFlashPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public FlashMainUI() {


        setLogoImage();

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

    private void setLogoImage() {
        try {
            Image image = ImageIO.read(new File("app/src/assets/flash_logo.png"));
            JLabel comp = new JLabel(new ImageIcon(image));
            mLogoImage.setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
            mLogoImage.add(comp, BorderLayout.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
