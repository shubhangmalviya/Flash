package com.flash.ui;

import javax.swing.*;

public class FormKeyValuePair {
    private JTextField mKey;
    private JTextField mValue;
    private JPanel mKeyValueContainer;

    public String getKey() {
        return mKey.getText();
    }

    public void setKey(String key) {
        mKey.setText(key);
    }

    public String getValue() {
        return mValue.getText();
    }

    public void setValue(String value) {
        mValue.setText(value);
    }

    public JPanel getKeyValueContainer() {
        return mKeyValueContainer;
    }
}
