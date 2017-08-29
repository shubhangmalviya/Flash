package com.flash.logic.postman.batch_request;

import com.flash.logic.postman.collection.ApiRequest;
import com.flash.logic.postman.collection.ErrorResponse;
import com.flash.logic.postman.collection.ResponseCallback;

/**
 * Task to fetch a postman collection detail.
 * @param <RESPONSE> the response format.
 */
public class Task<REQUEST_TOKEN, RESPONSE> {

    private ApiRequest<RESPONSE> mApiRequest;
    private Task<?,?> mNextTask;
    private TaskCompleteListener<REQUEST_TOKEN,RESPONSE> mTaskCompleteListener;
    private REQUEST_TOKEN mToken;

    public Task(ApiRequest<RESPONSE> apiRequest, REQUEST_TOKEN token) {
        mApiRequest = apiRequest;
        mToken = token;
    }

    public void setNextTask(Task<?,?> nextTask) {
        mNextTask = nextTask;
    }

    public void setTaskCompleteListener(TaskCompleteListener<REQUEST_TOKEN,RESPONSE> completeListener) {
        mTaskCompleteListener = completeListener;
    }


    public void performTask() {
        mApiRequest.makeRequest(new ResponseCallback<RESPONSE>() {
            @Override
            public void onSuccess(RESPONSE data) {
                if (mTaskCompleteListener != null) {
                    mTaskCompleteListener.onTaskSuccess(mToken, data);
                }

                performNextTask();

            }

            @Override
            public void onFailure(ErrorResponse errorResponse) {
                if (mTaskCompleteListener != null) {
                    boolean shouldProceed = mTaskCompleteListener.onTaskFailure(mToken, errorResponse.getMessage());

                    if (shouldProceed) {
                        performNextTask();
                    }
                }
            }
        });
    }

    private void performNextTask() {
        if (mNextTask != null) {
            mNextTask.performTask();
        }
    }
}
