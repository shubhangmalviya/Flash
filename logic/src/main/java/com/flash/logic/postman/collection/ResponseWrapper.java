package com.flash.logic.postman.collection;

import com.google.gson.JsonSyntaxException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

public class ResponseWrapper<T> implements Callback<T> {

    public static final int UNKNOWN = 1001;
    private final ResponseCallback<T> mResponseCallback;

    public ResponseWrapper(ResponseCallback<T> responseCallback) {
        mResponseCallback = responseCallback;
    }

    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            notifySuccessResult(response.body());
        }else {
            try {
                notifyErrorResult(new ErrorResponse(response.errorBody().string(), response.code(), null));
            } catch (IOException e) {
                notifyErrorResult(new ErrorResponse("Error parsing the response", response.code(), e));
            }
        }
    }

    public void onFailure(Call<T> call, Throwable throwable) {
        if (throwable instanceof ConnectException) {
            notifyErrorResult(new ErrorResponse("Error making api Request", UNKNOWN, throwable));
        }else if (throwable instanceof UnknownHostException) {
            notifyErrorResult(new ErrorResponse("Please make sure you are connected to the internet", UNKNOWN, throwable));
        }else if (throwable instanceof JsonSyntaxException){
            notifyErrorResult(new ErrorResponse("Response Parse Error", UNKNOWN, throwable));
        }else {
            notifyErrorResult(new ErrorResponse("Unknown Error", UNKNOWN, throwable));
        }
    }

    private void notifySuccessResult(T successResult) {
        if (mResponseCallback != null) {
            mResponseCallback.onSuccess(successResult);
        }
    }

    private void notifyErrorResult(ErrorResponse errorResponse) {
        if (mResponseCallback != null) {
            mResponseCallback.onFailure(errorResponse);
        }
    }
}
