package com.flash;

import javax.swing.*;
import java.awt.*;

public class PostmanCollectionRenderer extends JLabel implements ListCellRenderer<String> {

    private final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
    private final Icon mImage;

    public PostmanCollectionRenderer() {
        mImage = new ImageIcon("app/src/assets/postman_icon.png");
        setOpaque(true);
        setIconTextGap(12);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends String> list,
                                                  String value, int index, boolean isSelected, boolean cellHasFocus) {

        setIcon(mImage);
        setText(value);

        if (isSelected) {
            setBackground(HIGHLIGHT_COLOR);
            setForeground(Color.white);
        } else {
            setBackground(Color.white);
            setForeground(Color.black);
        }

        return this;
    }
}
