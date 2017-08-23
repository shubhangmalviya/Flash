package com.flash.ui;

import com.flash.DisplayPanelLifecycle;

import javax.swing.*;
import java.awt.*;

public class CollectionTree implements DisplayPanelLifecycle{
    private JPanel mContainerPanel;
    private JTree mCollectionTree;
    private JProgressBar mProgressBar;
    private JScrollPane mScrollbar;


    @Override
    public void onVisible() {
        CardLayout cardLayout = (CardLayout) mContainerPanel.getLayout();
        cardLayout.show(mContainerPanel, "Card2");
        mProgressBar.setIndeterminate(true);

    }


    public JPanel getFormPanel() {
        return mContainerPanel;
    }

    @Override
    public void onInvisible() {

    }
}
