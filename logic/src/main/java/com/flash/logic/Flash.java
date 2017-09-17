package com.flash.logic;

import com.flash.logic.postman.collection.ErrorResponse;
import com.flash.logic.postman.collection.ResponseCallback;
import com.flash.logic.postman.collection.detail.DetailApiRequest;
import com.flash.logic.postman.collection.detail.model.Formdata;
import com.flash.logic.postman.collection.detail.model.Item;
import com.flash.logic.postman.collection.detail.model.ResCollectionDetail;
import com.flash.logic.rest.post.form_data.FormDataRequestModelCreator;

import java.io.IOException;

public class Flash {

    public static void main(String[] args) throws IOException {

        String apiKey = "e0989dde7ea247c6bb0ba1eeae87a858";
        String collectionId = "640271-558a0312-96a0-3a60-e90e-b95441968b7f";

        DetailApiRequest apiRequest = new DetailApiRequest();
        apiRequest.makeRequest(collectionId, apiKey, new ResponseCallback<ResCollectionDetail>() {
            public void onSuccess(ResCollectionDetail data) {
                for (Item item : data.getCollection().getItems()) {
                    Formdata[] formdata = item.getRequest().getBody().getFormdata();
                    if (formdata != null && item.getRequest().getBody().getMode().equals("formdata") && item.getRequest().getMethod().equals("POST")) {
                        createClass(item.getName(), formdata);
                    }
                }
            }

            public void onFailure(ErrorResponse errorResponse) {
                System.out.print(errorResponse.getMessage());
                if (errorResponse.getThrowable() != null) {
                    errorResponse.getThrowable().printStackTrace();
                }
            }
        });
    }

    private static void createClass(String name, Formdata[] formdatas)  {
        name = name.replace(" ", "");
        String packageName = "com.daffodilsw.servicestemplate.post.formdata.sample";

        FormDataRequestModelCreator formDataRequestModelCreator = new FormDataRequestModelCreator(formdatas);
        formDataRequestModelCreator.createClass(packageName, "Req" + name);
        try {
            formDataRequestModelCreator.createFile("/Users/daffomac-14/Documents/Projects/ServicesTemplate/app/src/main/java/com/daffodilsw/servicestemplate/test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}