package com.flash;

import javax.swing.*;

public class PostmanAPIKeyUI {
    private JTextField mPostManApiKeyText;
    private JLabel mPostmanAPIKey;
    private JPanel mPostmanFormPanel;


    public static void main(String[] args) {
        JFrame frame = new JFrame("PostmanAPIKeyUI");
        frame.setContentPane(new PostmanAPIKeyUI().mPostmanFormPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPostmanFormPanel() {
        return mPostmanFormPanel;
    }
}
