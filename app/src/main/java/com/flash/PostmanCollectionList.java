package com.flash;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PostmanCollectionList {
    private JList mCollectionList;
    private JPanel mPanel1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("PostmanCollectionList");
        frame.setContentPane(new PostmanCollectionList().mPanel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public PostmanCollectionList() {


//        mPanel1.setSize();
        mCollectionList.addListSelectionListener(new PostmanCollectionListener());
    }

    private static class PostmanCollectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {

        }
    }
}
