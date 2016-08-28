package com.flash;

import com.flash.logic.postman.collection.ErrorResponse;
import com.flash.logic.postman.collection.ResponseCallback;
import com.flash.logic.postman.collection.list.CollectionListingApiRequest;
import com.flash.logic.postman.collection.list.model.ResPostmanCollectionList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.IOException;

public class PostmanCollectionList {
    private JList<String> mCollectionList;
    private JPanel mPanel1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("PostmanCollectionList");
        frame.setContentPane(new PostmanCollectionList().mPanel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public PostmanCollectionList() {

        try {
            mCollectionList.setCellRenderer(new PostmanCollectionRenderer());
            getCollectionDetail();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        mPanel1.setSize();
        mCollectionList.addListSelectionListener(new PostmanCollectionListener());
    }

    private void getCollectionDetail() {
        String apiKey = "e0989dde7ea247c6bb0ba1eeae87a858";

        CollectionListingApiRequest apiRequest = new CollectionListingApiRequest();
        apiRequest.makeRequest(apiKey, new ResponseCallback<ResPostmanCollectionList>() {
            public void onSuccess(ResPostmanCollectionList data) {
                DefaultListModel<String> model = new DefaultListModel<>();

                for (int index = 0; index < data.getCollections().length; index ++) {
                    model.add(index, data.getCollections()[index].getName());
                }

                mCollectionList.setModel(model);
            }

            public void onFailure(ErrorResponse errorResponse) {
                System.out.print(errorResponse.getMessage());
                if (errorResponse.getThrowable() != null) {
                    errorResponse.getThrowable().printStackTrace();
                }
            }
        });
    }

    public JPanel getFormPanel() {
        return mPanel1;
    }

    private static class PostmanCollectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {

        }
    }

    private class PostmanCollectionRenderer extends JLabel implements ListCellRenderer<String> {

        private final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
        private final Icon mImage;

        public PostmanCollectionRenderer() throws IOException {
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
}
