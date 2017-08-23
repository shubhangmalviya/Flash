package com.flash.logic.postman.batch_request;

import com.flash.logic.postman.collection.ApiRequest;
import com.flash.logic.postman.collection.ErrorResponse;
import com.flash.logic.postman.collection.ResponseCallback;
import com.sun.org.apache.regexp.internal.RE;

public class Task<RESPONSE> {

    private ApiRequest<RESPONSE> mApiRequest;
    private Task<?> mNextTask;

    public Task(ApiRequest<RESPONSE> apiRequest, TaskCompleteListener<RESPONSE> completeListener) {
        mApiRequest = apiRequest;
    }

    public void performTask(Task<?> nextTask) {
        mApiRequest.makeRequest(new ResponseCallback<RESPONSE>() {
            @Override
            public void onSuccess(RESPONSE data) {

            }

            @Override
            public void onFailure(ErrorResponse errorResponse) {

            }
        });
    }
}
