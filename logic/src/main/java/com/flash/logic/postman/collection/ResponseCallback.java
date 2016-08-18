package com.flash.logic.postman.collection;

public interface ResponseCallback<T> {

    void onSuccess(T data);

    void onFailure(ErrorResponse errorResponse);

}
